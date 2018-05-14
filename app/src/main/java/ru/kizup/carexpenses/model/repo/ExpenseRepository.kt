package ru.kizup.carexpenses.model.repo

import android.arch.lifecycle.LiveData
import io.reactivex.Completable
import ru.kizup.carexpenses.model.repo.db.DatabaseCreator
import ru.kizup.carexpenses.model.repo.db.entity.ExpenseEntity
import ru.kizup.carexpenses.utils.RxUtils

/**
 * Created by: dpuzikov on 14.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
object ExpenseRepository {

    private val expenseDao = DatabaseCreator.mDatabase.expenseDao()

    fun saveExpense(expenseEntity: ExpenseEntity): Completable = Completable.fromAction { expenseDao.saveExpense(expenseEntity) }
            .compose(RxUtils.computationToUiCompletable())

    fun getCarExpenses(carId: Long): LiveData<List<ExpenseEntity>> = expenseDao.getExpensesByCarId(carId)

}