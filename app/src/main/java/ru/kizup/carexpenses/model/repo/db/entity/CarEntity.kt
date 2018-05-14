package ru.kizup.carexpenses.model.repo.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by: dpuzikov on 13.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
@Entity(tableName = CarEntity.NAME)
@Parcelize
data class CarEntity(@PrimaryKey(autoGenerate = true) var id: Long,
                     var brand: String,
                     var model: String,
                     val year: Int,
                     val mileage: Long = 0) : Parcelable {

    companion object {
        const val NAME = "car"
    }
}