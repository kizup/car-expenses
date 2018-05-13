package ru.kizup.carexpenses.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.os.Handler

/**
 * Created by: dpuzikov on 12.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
const val DELAY = 1000L

class SplashViewModel : BaseViewModel() {

    private val mData: MutableLiveData<Boolean> = MutableLiveData()
    private val handler: Handler = Handler()
    private val delay = Runnable {
        mData.postValue(true)
    }

    init {
        handler.postDelayed(delay, DELAY)
        mData.value = false
    }

    fun getData(): LiveData<Boolean> {
        return mData
    }

    override fun onCleared() {
        super.onCleared()
        handler.removeCallbacks(delay)
    }

}