package ru.kizup.carexpenses.view.addcar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import ru.kizup.carexpenses.R
import ru.kizup.carexpenses.view.base.BaseActivity

/**
 * Created by: dpuzikov on 13.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
class AddCarActivity : BaseActivity() {

    companion object {
        fun buildIntent(context: Context) = Intent(context, AddCarActivity::class.java)
    }

    override fun getLayoutId() = R.layout.activity_add_car

    override fun getFragmentContainerId() = R.id.add_car_fragment_container

    override fun onCreated(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            showFragment(AddCarFragment.newInstance())
        }
    }


}