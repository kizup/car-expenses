package ru.kizup.carexpenses.view.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import ru.kizup.carexpenses.R
import ru.kizup.carexpenses.view.base.BaseFragment
import ru.kizup.carexpenses.viewmodel.EmptyCarsViewModel

import kotlinx.android.synthetic.main.fragment_empty_cars.*
import ru.kizup.carexpenses.view.addcar.AddCarActivity

/**
 * Created by: dpuzikov on 12.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
class EmptyCarsFragment : BaseFragment<EmptyCarsViewModel>() {

    override val mClassToken: Class<EmptyCarsViewModel>
        get() = EmptyCarsViewModel::class.java

    companion object {
        fun newInstance(): EmptyCarsFragment {
            val fragment = EmptyCarsFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun getLayoutId() = R.layout.fragment_empty_cars

    override fun onPostCreated(savedInstanceState: Bundle?) {
        registerLiveData()
        fabAddCar.setOnClickListener { mViewModel.onAddCarClick() }
    }

    private fun registerLiveData() {
        mViewModel.uiActionsLiveData.observe(this, Observer<Int> { uiAction ->
            when (uiAction) {
                EmptyCarsViewModel.UI_ACTION_ADD_CAR -> startActivity(AddCarActivity.buildIntent(mBaseActivity))
            }
        })
    }
}