package ru.kizup.carexpenses.view.yearpicker

import android.content.Context
import android.view.ViewGroup
import ru.kizup.carexpenses.R
import ru.kizup.carexpenses.view.base.BaseAdapter
import java.util.*

/**
 * Created by: dpuzikov on 14.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
class YearAdapter(context: Context) : BaseAdapter<Int, YearViewHolder>(context, null) {

    init {
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        for (i in currentYear downTo currentYear - 50) {
            mItems.add(0, i)
        }

        mItems.add(0, EMPTY)
        mItems.add(0, EMPTY)
        mItems.add(EMPTY)
        mItems.add(EMPTY)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): YearViewHolder = YearViewHolder(inflate(R.layout.item_year, parent!!))

    override fun onBindViewHolder(holder: YearViewHolder?, position: Int) {
        holder?.let {
            val year = getItem(it.adapterPosition)
            val string = when (year) {
                EMPTY -> ""
                else -> year.toString()
            }
            it.mYearTextView.text = string
        }
    }

    companion object {
        const val EMPTY = -1
    }

}