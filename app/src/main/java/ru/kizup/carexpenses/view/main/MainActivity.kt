package ru.kizup.carexpenses.view.main

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import ru.kizup.carexpenses.R
import ru.kizup.carexpenses.view.base.BaseViewModelActivity
import ru.kizup.carexpenses.viewmodel.MainViewModel

/**
 * Created by: dpuzikov on 12.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
class MainActivity : BaseViewModelActivity<MainViewModel>() {
    override val clazz: Class<MainViewModel>
        get() = MainViewModel::class.java

    companion object {
        fun buildIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    private var mCarsCount: Int = 0

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getFragmentContainerId(): Int = R.id.main_fragment_container

    override fun onCreated(savedInstanceState: Bundle?) {
        mBaseViewModel.getCarsCountLive().observe(this, Observer<Int> {cars ->
            when (cars) {
                0 -> showFragment(EmptyCarsFragment.newInstance())
                else -> {
                    if (mCarsCount == 0) {
                        showFragment(CarsListFragment.newInstance())
                    }
                }
            }
            mCarsCount = cars!!
        })
    }

}