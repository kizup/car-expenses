package ru.kizup.carexpenses.viewmodel

import android.arch.lifecycle.MutableLiveData
import ru.kizup.carexpenses.model.repo.CarsRepository
import ru.kizup.carexpenses.model.repo.db.entity.CarEntity

/**
 * Created by: dpuzikov on 13.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
class AddCarViewModel : BaseViewModel() {

    val isSuccessSaveCar = MutableLiveData<Boolean>()


    init {
        isSuccessSaveCar.value = false
    }

    fun saveCar(brand: String, model: String, year: Int) {
        CarsRepository.saveCar(CarEntity(0, brand, model, year))
                .subscribe {
                    isSuccessSaveCar.value = true
                }
    }

}