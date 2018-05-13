package ru.kizup.carexpenses.view.splash

import android.os.Bundle
import ru.kizup.carexpenses.R
import ru.kizup.carexpenses.view.base.BaseActivity

/**
 * Created by: dpuzikov on 12.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
class SplashActivity : BaseActivity() {

    override fun getFragmentContainerId() = R.id.splash_fragment_container

    override fun getLayoutId() = R.layout.activity_splash

    override fun onCreated(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            showFragment(SplashFragment.netInstance())
        }
    }

}