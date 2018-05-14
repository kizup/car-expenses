package ru.kizup.carexpenses.view.carview

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_car_details.*
import ru.kizup.carexpenses.R
import ru.kizup.carexpenses.ScrollingActivity
import ru.kizup.carexpenses.model.repo.db.entity.CarEntity
import ru.kizup.carexpenses.view.base.BaseFragment

/**
 * Created by: dpuzikov on 14.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
class CarDetailsFragment : BaseFragment<CarDetailsViewModel>() {

    private lateinit var listener: Listener

    companion object {

        const val CAR_ARG = "car_arg"

        fun newInstance(car: CarEntity): CarDetailsFragment {
            val fragment = CarDetailsFragment()
            val args = Bundle()
            args.putParcelable(CAR_ARG, car)
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var adapter: ExpensesAdapter

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = context as Listener
        mViewModel.setCar(arguments?.getParcelable(CAR_ARG)!!).observe(this, Observer { adapter.setItems(it!!) })
        adapter = ExpensesAdapter(context)
    }

    override fun getLayoutId(): Int = R.layout.fragment_car_details

    override fun onPostCreated(savedInstanceState: Bundle?) {
        setToolbar(toolbar)

        rvExpenses.layoutManager = LinearLayoutManager(mBaseActivity)
        rvExpenses.addItemDecoration(DividerItemDecoration(mBaseActivity, DividerItemDecoration.VERTICAL))
        rvExpenses.adapter = adapter

        fabEditCar.setOnClickListener { startActivity(Intent(mBaseActivity, ScrollingActivity::class.java)) }
        bnAddExpense.setOnClickListener { listener.onAddExpenseClick(mViewModel.car!!.id) }
    }

    override val mClassToken: Class<CarDetailsViewModel>
        get() = CarDetailsViewModel::class.java

    interface Listener {
        fun onAddExpenseClick(carId: Long)
    }
}