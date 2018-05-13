package ru.kizup.carexpenses.view.splash

import android.arch.lifecycle.Observer
import android.os.Bundle
import ru.kizup.carexpenses.R
import ru.kizup.carexpenses.view.base.BaseFragment
import ru.kizup.carexpenses.view.main.MainActivity
import ru.kizup.carexpenses.viewmodel.SplashViewModel

/**
 * Created by: dpuzikov on 12.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
class SplashFragment : BaseFragment<SplashViewModel>() {

    override val mClassToken: Class<SplashViewModel>
        get() = SplashViewModel::class.java

    companion object {
        fun netInstance(): SplashFragment {
            val args = Bundle()
            val fragment = SplashFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onPostCreated(savedInstanceState: Bundle?) {
        mViewModel.getData().observe(this, Observer<Boolean> { status ->
            if (status!!) {
                mBaseActivity.finish()
                startActivity(MainActivity.buildIntent(mBaseActivity))
            }
        })
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_splash
    }
}