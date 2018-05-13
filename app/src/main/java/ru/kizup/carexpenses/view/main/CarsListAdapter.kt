package ru.kizup.carexpenses.view.main

import android.content.Context
import android.view.ViewGroup
import ru.kizup.carexpenses.R
import ru.kizup.carexpenses.model.repo.db.entity.CarEntity
import ru.kizup.carexpenses.view.base.BaseAdapter

/**
 * Created by: dpuzikov on 13.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
class CarsListAdapter(context: Context,
                      private val thisListener: Listener) : BaseAdapter<CarEntity, CarViewHolder>(context, null) {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CarViewHolder {
        val holder = CarViewHolder(inflate(R.layout.item_car, parent!!))
        holder.itemView.setOnClickListener { thisListener.onItemClick(getItem(holder.adapterPosition)) }
        holder.mRemoveCarButton.setOnClickListener { thisListener.onRemoveClick(getItem(holder.adapterPosition)) }
        return holder
    }

    override fun onBindViewHolder(holder: CarViewHolder?, position: Int) {
        val entity = getItem(position)
        holder?.let {
            it.mCarBrandTextView.text = entity.brand
            it.mCarModelTextView.text = entity.model
        }
    }

    interface Listener {

        fun onRemoveClick(car: CarEntity)

        fun onItemClick(car: CarEntity)

    }

}