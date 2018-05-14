package ru.kizup.carexpenses.model.repo.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import ru.kizup.carexpenses.model.repo.db.entity.ExpenseEntity

/**
 * Created by: dpuzikov on 14.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */

@Dao
interface ExpenseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveExpense(expenseEntity: ExpenseEntity)

    @Query("SELECT * FROM expense WHERE car_id = :id")
    fun getExpensesByCarId(id: Long) : LiveData<List<ExpenseEntity>>

}