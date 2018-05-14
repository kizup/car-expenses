package ru.kizup.carexpenses.view.addcar

import android.arch.lifecycle.Observer
import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_add_car.*
import ru.kizup.carexpenses.R
import ru.kizup.carexpenses.view.base.BaseFragment
import ru.kizup.carexpenses.view.yearpicker.YearPickerBottomDialog
import ru.kizup.carexpenses.viewmodel.AddCarViewModel

/**
 * Created by: dpuzikov on 13.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
class AddCarFragment : BaseFragment<AddCarViewModel>() {

    companion object {
        fun newInstance(): AddCarFragment {
            val args = Bundle()
            val fragment = AddCarFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun getLayoutId() = R.layout.fragment_add_car

    override fun onPostCreated(savedInstanceState: Bundle?) {
        mViewModel.isSuccessSaveCar
                .observe(this, Observer { success ->
                    success?.let {
                        if (it) {
                            mBaseActivity.finish()
                        }
                    }
                })

        bnSaveCar.setOnClickListener {
            mViewModel.saveCar(etCarBrand.text.toString(),
                    etCarModel.text.toString(),
                    etCarMileage.text.toString())
        }
        bnSelectYear.setOnClickListener {
            YearPickerBottomDialog.Builder.withListener(object : YearPickerBottomDialog.OnYearSelectedListener {
                override fun onYearSelected(year: Int) {
                    tvCarYear.text = year.toString()
                    mViewModel.onYearSelected(year)
                }
            }).show(childFragmentManager)
        }
    }

    override val mClassToken: Class<AddCarViewModel>
        get() = AddCarViewModel::class.java
}