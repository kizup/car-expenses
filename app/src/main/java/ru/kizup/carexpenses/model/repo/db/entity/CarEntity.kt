package ru.kizup.carexpenses.model.repo.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by: dpuzikov on 13.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
const val NAME = "car"

@Entity(tableName = NAME)
data class CarEntity(@PrimaryKey(autoGenerate = true) var id: Long,
                     var brand: String,
                     var model: String,
                     val year: Int)