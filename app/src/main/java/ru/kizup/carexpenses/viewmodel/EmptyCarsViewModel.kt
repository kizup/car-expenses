package ru.kizup.carexpenses.viewmodel

import android.arch.lifecycle.MutableLiveData

/**
 * Created by: dpuzikov on 12.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
class EmptyCarsViewModel : BaseViewModel() {

    val uiActionsLiveData = MutableLiveData<Int>()

    init {
        uiActionsLiveData.value = UI_ACTION_NONE
    }

    fun onAddCarClick() {
        uiActionsLiveData.value = UI_ACTION_ADD_CAR
    }

    companion object {

        const val UI_ACTION_NONE = 0
        const val UI_ACTION_ADD_CAR = 1

    }

}