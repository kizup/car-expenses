package ru.kizup.carexpenses.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.text.TextUtils
import ru.kizup.carexpenses.model.repo.ExpenseRepository
import ru.kizup.carexpenses.model.repo.db.entity.ExpenseEntity
import java.util.*

/**
 * Created by: dpuzikov on 14.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
class AddCarExpenseViewModel : BaseViewModel() {

    var carId = 0L
    val isSaveExpenseLive = MutableLiveData<Boolean>()

    fun onSaveExpenseClick(name: String,
                           cost: String,
                           mileage: String) {
        var costDouble = 0.0
        try {
            if (!TextUtils.isEmpty(cost)) {
                costDouble = cost.toDouble()
            }
        } catch (e: NumberFormatException) {
            e.printStackTrace()
        }

        var mileageLong = 0L
        try {
            if (!TextUtils.isEmpty(mileage)) {
                mileageLong = mileage.toLong()
            }
        } catch (e: NumberFormatException) {
            e.printStackTrace()
        }

        val expense = ExpenseEntity(carId = carId, name = name, expense = costDouble, mileage = mileageLong, expenseTimestamp = Date().time)
        ExpenseRepository.saveExpense(expense)
                .subscribe({
                    isSaveExpenseLive.value = true
                })
    }

}