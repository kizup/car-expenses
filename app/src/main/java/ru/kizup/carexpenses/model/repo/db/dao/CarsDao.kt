package ru.kizup.carexpenses.model.repo.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import ru.kizup.carexpenses.model.repo.db.entity.CarEntity
import ru.kizup.carexpenses.model.repo.db.entity.NAME

/**
 * Created by: dpuzikov on 13.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
@Dao
interface CarsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewCar(car: CarEntity)

    @Query("SELECT * FROM $NAME")
    fun loadAllCars(): LiveData<List<CarEntity>>

    @Query("SELECT * FROM $NAME")
    fun loadAllCarsIdLive(): LiveData<List<CarEntity>>

    @Query("SELECT * FROM $NAME Count")
    fun getCarsCount(): Int

    @Delete
    fun remove(car: CarEntity)

//    @Query("SELECT * FROM $NAME Count")
//    fun getCarsCountLive(): LiveData<Int>

}