package ru.kizup.carexpenses.view.main

import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.support.v7.util.DiffUtil
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_cars_list.*
import ru.kizup.carexpenses.R
import ru.kizup.carexpenses.model.repo.db.entity.CarEntity
import ru.kizup.carexpenses.view.addcar.AddCarActivity
import ru.kizup.carexpenses.view.base.BaseFragment
import ru.kizup.carexpenses.view.carview.CarViewActivity
import ru.kizup.carexpenses.viewmodel.CarsListViewModel

/**
 * Created by: dpuzikov on 12.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
class CarsListFragment : BaseFragment<CarsListViewModel>(), CarsListAdapter.Listener {

    override val mClassToken: Class<CarsListViewModel>
        get() = CarsListViewModel::class.java

    companion object {
        fun newInstance(): CarsListFragment {
            val fragment = CarsListFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var adapter: CarsListAdapter

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        adapter = CarsListAdapter(context!!, this)
    }

    override fun getLayoutId(): Int = R.layout.fragment_cars_list

    override fun onPostCreated(savedInstanceState: Bundle?) {
        rvCars.layoutManager = LinearLayoutManager(mBaseActivity)
        rvCars.addItemDecoration(DividerItemDecoration(mBaseActivity, DividerItemDecoration.VERTICAL))
        rvCars.adapter = adapter

        fabAddCar.setOnClickListener { mViewModel.onAddCarClick() }

        mViewModel.getCars()
                .observe(this, Observer<List<CarEntity>> { cars ->
                    DiffUtil.calculateDiff(CarsListDiffUtilsCallback(adapter.mItems, cars!!))
                            .dispatchUpdatesTo(adapter)
                    adapter.setItems(cars, false)
                })
        mViewModel.uiActionsLiveData.observe(this, Observer { action ->
            when (action) {
                CarsListViewModel.UI_ACTION_ADD_CAR -> startActivity(AddCarActivity.buildIntent(mBaseActivity))
            }
        })
    }

    override fun onItemClick(car: CarEntity) {
        startActivity(CarViewActivity.buildIntent(mBaseActivity, car))
    }

    override fun onRemoveClick(car: CarEntity) {
        mViewModel.removeCar(car)
    }
}