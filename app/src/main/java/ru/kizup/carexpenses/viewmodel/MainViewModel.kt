package ru.kizup.carexpenses.viewmodel

import android.arch.core.util.Function
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import ru.kizup.carexpenses.model.repo.CarsRepository
import ru.kizup.carexpenses.model.repo.db.entity.CarEntity

/**
 * Created by: dpuzikov on 12.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
class MainViewModel: BaseViewModel() {

    enum class ScreenType {
        EmptyCarsScreen,
        CarsListScreen
    }

    private val mScreenTypeLiveData = MutableLiveData<ScreenType>()

    fun getScreenTypesLiveData() = mScreenTypeLiveData

    fun getCarsCountLive(): LiveData<Int> {
        return Transformations.map(CarsRepository.getCarsCountLive(), { cars -> cars.size })
    }

}