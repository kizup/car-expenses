package ru.kizup.carexpenses.view.carview

import android.arch.lifecycle.Observer
import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_add_expense.*
import ru.kizup.carexpenses.R
import ru.kizup.carexpenses.view.base.BaseFragment
import ru.kizup.carexpenses.viewmodel.AddCarExpenseViewModel

/**
 * Created by: dpuzikov on 14.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
class AddExpenseFragment : BaseFragment<AddCarExpenseViewModel>() {

    companion object {
        fun newInstance(carId: Long): AddExpenseFragment {
            val fragment = AddExpenseFragment()
            val args = Bundle()
            args.putLong(CAR_ID_ARG, carId)
            fragment.arguments = args
            return fragment
        }

        private const val CAR_ID_ARG = "car_id_arg"
    }

    override fun getLayoutId(): Int = R.layout.fragment_add_expense

    override fun onPostCreated(savedInstanceState: Bundle?) {
        bnSaveExpense.setOnClickListener { mViewModel.onSaveExpenseClick(etExpenseName.text.toString(),
                etExpenseCost.text.toString(),
                etExpenseMileage.text.toString()) }

        mViewModel.carId = arguments!!.getLong(CAR_ID_ARG)
        mViewModel.isSaveExpenseLive.observe(this, Observer {
            if (it!!) {
                mBaseActivity.onBackPressed()
            }
        })
    }

    override val mClassToken: Class<AddCarExpenseViewModel>
        get() = AddCarExpenseViewModel::class.java
}