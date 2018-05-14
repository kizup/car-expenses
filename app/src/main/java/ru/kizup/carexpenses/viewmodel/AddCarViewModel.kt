package ru.kizup.carexpenses.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.text.TextUtils
import ru.kizup.carexpenses.model.repo.CarsRepository
import ru.kizup.carexpenses.model.repo.db.entity.CarEntity

/**
 * Created by: dpuzikov on 13.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
class AddCarViewModel : BaseViewModel() {

    val isSuccessSaveCar = MutableLiveData<Boolean>()
    private var year: Int = 0

    init {
        isSuccessSaveCar.value = false
    }

    fun saveCar(brand: String, model: String, mileageStr: String) {
        var  mileage = 0L
        if (TextUtils.isDigitsOnly(mileageStr)) {
            mileage = mileageStr.toLong()
        }
        CarsRepository.saveCar(CarEntity(0, brand, model, year, mileage))
                .subscribe {
                    isSuccessSaveCar.value = true
                }
    }

    fun onYearSelected(year: Int) {
        this.year = year
    }

}