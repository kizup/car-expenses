package ru.kizup.carexpenses.model.repo.db

import android.arch.lifecycle.MutableLiveData
import android.arch.persistence.room.Room
import android.content.Context
import io.reactivex.Completable
import ru.kizup.carexpenses.utils.RxUtils
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Created by: dpuzikov on 13.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
object DatabaseCreator {

    val isDbCreated = MutableLiveData<Boolean>()
    lateinit var mDatabase: CarsDatabase
    private val mInitializing = AtomicBoolean(true)

    fun createDb(context: Context) {
        if (mInitializing.compareAndSet(true, false).not()) {
            return
        }
        isDbCreated.value = false
        Completable.fromAction {
            mDatabase = Room.databaseBuilder(context, CarsDatabase::class.java, CarsDatabase.DATABASE_NAME)
                    .build()
        }.compose(RxUtils.computationToUiCompletable())
                .subscribe({
                    isDbCreated.value = true
                })
    }

}