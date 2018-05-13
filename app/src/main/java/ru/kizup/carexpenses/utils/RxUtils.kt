package ru.kizup.carexpenses.utils

import io.reactivex.CompletableTransformer
import io.reactivex.FlowableTransformer
import io.reactivex.Scheduler
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by: dpuzikov on 13.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
object RxUtils {

    fun io(): Scheduler = Schedulers.io()
    fun ui(): Scheduler = AndroidSchedulers.mainThread()
    fun computation(): Scheduler = Schedulers.computation()

    fun computationToUiCompletable() = CompletableTransformer { upstream ->
        upstream.subscribeOn(computation())
                .observeOn(ui())
    }

    fun <T> computationToUiSingle() = SingleTransformer<T, T> { upstream ->
        upstream.subscribeOn(computation())
                .observeOn(ui())
    }

    fun <T> computationToUiFlowable() = FlowableTransformer<T, T> { upstream ->
        upstream.subscribeOn(computation())
                .observeOn(ui())
    }

}