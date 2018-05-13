package ru.kizup.carexpenses.view.base

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import ru.kizup.carexpenses.viewmodel.BaseViewModel

/**
 * Created by: dpuzikov on 12.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */

abstract class BaseViewModelActivity<T: BaseViewModel>: BaseActivity() {

    protected abstract val clazz: Class<T>
    protected lateinit var mBaseViewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        mBaseViewModel = ViewModelProviders.of(this).get(clazz)
        super.onCreate(savedInstanceState)
    }

}