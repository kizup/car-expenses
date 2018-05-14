package ru.kizup.carexpenses.view.carview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import ru.kizup.carexpenses.R
import ru.kizup.carexpenses.model.repo.db.entity.CarEntity
import ru.kizup.carexpenses.view.base.BaseActivity

/**
 * Created by: dpuzikov on 14.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */

class CarViewActivity : BaseActivity(), CarDetailsFragment.Listener {

    companion object {

        private const val CAR_EXTRA = "car_extra"

        fun buildIntent(context: Context, car: CarEntity): Intent {
            val intent = Intent(context, CarViewActivity::class.java)
            intent.putExtra(CAR_EXTRA, car)
            return intent
        }
    }

    override fun getLayoutId(): Int = R.layout.activity_car_view

    override fun getFragmentContainerId(): Int = R.id.car_view_fragment_container

    override fun onCreated(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            showFragment(CarDetailsFragment.newInstance(intent.getParcelableExtra(CAR_EXTRA)))
        }
    }

    override fun onAddExpenseClick(carId: Long) {
        showFragment(AddExpenseFragment.newInstance(carId), addToBackStack = true)
    }

}