package ru.kizup.carexpenses.viewmodel

import android.arch.lifecycle.MutableLiveData
import ru.kizup.carexpenses.model.repo.CarsRepository
import ru.kizup.carexpenses.model.repo.db.entity.CarEntity

/**
 * Created by: dpuzikov on 12.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
class CarsListViewModel : BaseViewModel() {

    val uiActionsLiveData = MutableLiveData<Int>()

    init {
        uiActionsLiveData.value = UI_ACTION_NONE
    }

    fun getCars() = CarsRepository.getCarsList()

    fun onAddCarClick() {
        uiActionsLiveData.value = UI_ACTION_ADD_CAR
        uiActionsLiveData.value = UI_ACTION_NONE
    }

    companion object {

        const val UI_ACTION_NONE = 0
        const val UI_ACTION_ADD_CAR = 1

    }

    fun removeCar(car: CarEntity) {
        CarsRepository.removeCar(car)
                .subscribe()
    }
}