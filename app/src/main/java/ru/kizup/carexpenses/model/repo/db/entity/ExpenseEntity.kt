package ru.kizup.carexpenses.model.repo.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by: dpuzikov on 14.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
@Entity(tableName = ExpenseEntity.NAME)
data class ExpenseEntity(@PrimaryKey(autoGenerate = true) val id: Long = 0,
                         @ColumnInfo(name = CAR_ID, index = true) val carId: Long,
                         @ColumnInfo(name = EXPENSE_NAME) val name: String,
                         @ColumnInfo(name = EXPENSE_VALUE) val expense: Double,
                         @ColumnInfo(name = MILEAGE) val mileage: Long = 0,
                         @ColumnInfo(name = EXPENSE_DATE) val expenseTimestamp: Long) {

    companion object {
        const val NAME = "expense"
        const val CAR_ID = "car_id"
        const val EXPENSE_VALUE = "expense_value"
        const val MILEAGE = "mileage"
        const val EXPENSE_DATE = "expense_date"
        const val EXPENSE_NAME = "expense_name"
    }

}