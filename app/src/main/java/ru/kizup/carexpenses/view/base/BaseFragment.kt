package ru.kizup.carexpenses.view.base

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.kizup.carexpenses.viewmodel.BaseViewModel

/**
 * Created by: dpuzikov on 12.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
abstract class BaseFragment<T: BaseViewModel>: Fragment() {

    @LayoutRes abstract fun getLayoutId(): Int
    abstract fun onPostCreated(savedInstanceState: Bundle?)

    protected lateinit var mViewModel: T
    protected abstract val mClassToken: Class<T>
    protected lateinit var mBaseActivity: BaseActivity

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mBaseActivity = context as BaseActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProviders.of(this)
                .get(mClassToken)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onPostCreated(savedInstanceState)
    }
}