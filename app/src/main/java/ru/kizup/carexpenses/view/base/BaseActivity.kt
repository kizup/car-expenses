package ru.kizup.carexpenses.view.base

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

/**
 * Created by: dpuzikov on 12.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
abstract class BaseActivity : AppCompatActivity() {

    @LayoutRes
    abstract fun getLayoutId(): Int

    @IdRes
    abstract fun getFragmentContainerId(): Int

    abstract fun onCreated(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        onCreated(savedInstanceState)
    }

    protected fun showFragment(fragment: Fragment, transition: Boolean = true, addToBackStack: Boolean = false) {
        val transaction = supportFragmentManager.beginTransaction()
        if (transition) {
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        }
        if (addToBackStack) {
            transaction.addToBackStack(null)
        }
        transaction.replace(getFragmentContainerId(), fragment)
                .commit()
    }

}