package ru.kizup.carexpenses.view.base

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.kizup.carexpenses.utils.OnItemClickListener

/**
 * Created by: dpuzikov on 13.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
abstract class BaseAdapter<Item, Holder : BaseViewHolder>(context: Context,
                                                          val listener: OnItemClickListener<Item>?) : RecyclerView.Adapter<Holder>() {

    val mItems = ArrayList<Item>()
    private val mInflater = LayoutInflater.from(context)

    override fun getItemCount() = mItems.size

    protected fun inflate(@LayoutRes idRes: Int, parent: ViewGroup) : View = mInflater.inflate(idRes, parent, false)

    fun getItem(position: Int) = mItems[position]

    fun setItems(items: List<Item>, notify: Boolean = true) {
        mItems.clear()
        mItems.addAll(items)

        if (notify) notifyDataSetChanged()
    }

}