package ru.kizup.carexpenses.view.carview

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import ru.kizup.carexpenses.model.repo.ExpenseRepository
import ru.kizup.carexpenses.model.repo.db.entity.CarEntity
import ru.kizup.carexpenses.model.repo.db.entity.ExpenseEntity
import ru.kizup.carexpenses.viewmodel.BaseViewModel

/**
 * Created by: dpuzikov on 14.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
class CarDetailsViewModel : BaseViewModel() {

    var car: CarEntity? = null
        get() = field

    fun setCar(car: CarEntity): LiveData<List<ExpenseEntity>> {
        this.car = car
        return ExpenseRepository.getCarExpenses(car.id)
    }

}