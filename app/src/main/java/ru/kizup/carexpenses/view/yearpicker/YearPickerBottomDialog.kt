package ru.kizup.carexpenses.view.yearpicker

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v4.app.FragmentManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSnapHelper
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.year_picker_dialog.*
import ru.kizup.carexpenses.R

/**
 * Created by: dpuzikov on 14.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
class YearPickerBottomDialog : BottomSheetDialogFragment() {

    private lateinit var adapter: YearAdapter
    private var listener: OnYearSelectedListener? = null
    private lateinit var layoutManager: LinearLayoutManager
    private var selectedPosition: Int = 0
    private val snapHelper = LinearSnapHelper()

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        adapter = YearAdapter(context!!)
        layoutManager = LinearLayoutManager(context)
    }

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.year_picker_dialog, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvYears.layoutManager = layoutManager
        rvYears.adapter = adapter
        rvYears.scrollToPosition(adapter.itemCount - 1)

        fabSelectYear.setOnClickListener {
            listener?.onYearSelected(adapter.getItem(selectedPosition))
            dismiss()
        }

        rvYears.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                selectedPosition = layoutManager.findFirstVisibleItemPosition() + 2
            }
        })
        snapHelper.attachToRecyclerView(rvYears)
    }

    interface OnYearSelectedListener {
        fun onYearSelected(year: Int)
    }

    object Builder {

        private var listener: OnYearSelectedListener? = null

        fun withListener(listener: OnYearSelectedListener?): Builder {
            this.listener = listener
            return this
        }

        fun show(fragmentManager: FragmentManager) {
            val yearFragment = YearPickerBottomDialog()
            yearFragment.listener = this.listener
            yearFragment.show(fragmentManager, YearPickerBottomDialog::class.java.simpleName)
        }
    }

}