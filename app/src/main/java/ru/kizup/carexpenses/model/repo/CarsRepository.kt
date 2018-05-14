package ru.kizup.carexpenses.model.repo

import io.reactivex.Completable
import io.reactivex.Flowable
import ru.kizup.carexpenses.model.repo.db.DatabaseCreator
import ru.kizup.carexpenses.model.repo.db.entity.CarEntity
import ru.kizup.carexpenses.utils.RxUtils

/**
 * Created by: dpuzikov on 12.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
object CarsRepository {

    private val carsDao = DatabaseCreator.mDatabase.carsDao()

    fun getCarsCount() = Flowable.fromCallable { carsDao.getCarsCount() }
            .compose(RxUtils.computationToUiFlowable())

    fun getCarsCountLive() = carsDao.loadAllCarsIdLive()

    fun getCarsList() = carsDao.loadAllCars()

    fun saveCar(car: CarEntity) = Completable.fromAction { carsDao.insertNewCar(car) }
            .compose(RxUtils.computationToUiCompletable())

    fun removeCar(car: CarEntity): Completable = Completable.fromAction {
        carsDao.remove(car)
    }.compose(RxUtils.computationToUiCompletable())

}