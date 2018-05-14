package ru.kizup.carexpenses.view.carview

import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.item_expense.view.*
import ru.kizup.carexpenses.R
import ru.kizup.carexpenses.view.base.BaseViewHolder

/**
 * Created by: dpuzikov on 14.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
class ExpenseViewHolder(itemView: View) : BaseViewHolder(itemView) {

    val mExpenseNameTextView: TextView = findViewById(R.id.tvExpenseName)
    val mExpenseCostTextView: TextView = findViewById(R.id.tvExpenseCost)

}