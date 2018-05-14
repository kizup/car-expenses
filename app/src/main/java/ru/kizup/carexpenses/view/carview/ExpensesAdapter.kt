package ru.kizup.carexpenses.view.carview

import android.content.Context
import android.view.ViewGroup
import ru.kizup.carexpenses.R
import ru.kizup.carexpenses.model.repo.db.entity.ExpenseEntity
import ru.kizup.carexpenses.view.base.BaseAdapter

/**
 * Created by: dpuzikov on 14.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
class ExpensesAdapter(context: Context) : BaseAdapter<ExpenseEntity, ExpenseViewHolder>(context, null) {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ExpenseViewHolder = ExpenseViewHolder(inflate(R.layout.item_expense, parent!!))

    override fun onBindViewHolder(holder: ExpenseViewHolder?, position: Int) {
        holder?.let {
            val expense = getItem(it.adapterPosition)
            it.mExpenseNameTextView.text = expense.name
            it.mExpenseCostTextView.text = it.itemView.resources.getString(R.string.expense_cost_mask, expense.expense)
        }
    }


}