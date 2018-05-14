package ru.kizup.carexpenses

import android.app.Application
import com.amitshekhar.DebugDB
import ru.kizup.carexpenses.model.repo.db.DatabaseCreator

/**
 * Created by: dpuzikov on 13.05.18.
 * e-mail: kizup.diman@gmail.com
 * Skype: kizupx
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        DatabaseCreator.createDb(this)
        DebugDB.initialize(this)
    }

}