package jp.local.yukichan.selfmanager2

import android.app.Application
import timber.log.Timber

/**
 * Created by takamk2 on 18/03/08.
 *
 * The Edit Fragment of Base Class.
 */
class CustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}