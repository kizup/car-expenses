package ru.kizup.carexpenses.model.repo.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import ru.kizup.carexpenses.model.repo.db.dao.CarsDao
import ru.kizup.carexpenses.model.repo.db.entity.CarEntity

/**
 * Created by: dpuzikov on 13.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
@Database(entities = arrayOf(CarEntity::class), version = 1, exportSchema = false)
abstract class CarsDatabase : RoomDatabase() {

    abstract fun carsDao(): CarsDao

    companion object {
        const val DATABASE_NAME = "cars.db"
    }

}