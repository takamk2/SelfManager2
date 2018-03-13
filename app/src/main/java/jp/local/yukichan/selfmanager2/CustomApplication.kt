package jp.local.yukichan.selfmanager2

import android.app.Application
import jp.local.yukichan.selfmanager2.data.datastore.MeasureInfoDataStore
import jp.local.yukichan.selfmanager2.data.datastore.internal.InternalMeasureInfoDataStore
import timber.log.Timber

/**
 * Created by takamk2 on 18/03/08.
 *
 * The Edit Fragment of Base Class.
 */
class CustomApplication : Application() {

    lateinit var measureInfoDataStore: MeasureInfoDataStore

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        measureInfoDataStore = InternalMeasureInfoDataStore(this)
    }
}