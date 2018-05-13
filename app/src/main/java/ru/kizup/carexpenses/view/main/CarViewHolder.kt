package ru.kizup.carexpenses.view.main

import android.view.View
import android.widget.Button
import android.widget.TextView
import ru.kizup.carexpenses.R
import ru.kizup.carexpenses.view.base.BaseViewHolder

/**
 * Created by: dpuzikov on 13.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
class CarViewHolder(itemView: View) : BaseViewHolder(itemView) {

    val mCarBrandTextView = findViewById<TextView>(R.id.tv_car_brand)
    val mCarModelTextView = findViewById<TextView>(R.id.tv_car_model)
    val mRemoveCarButton = findViewById<Button>(R.id.bn_remove_car)

}