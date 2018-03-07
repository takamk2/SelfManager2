package jp.local.yukichan.selfmanager2.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides
import jp.local.yukichan.selfmanager2.view.fragment.EditUserFragment
import javax.inject.Singleton

@Module
class ActivityModule(private val activity: Activity) {

    @Singleton
    @Provides
    fun provideEditUserFragment(): EditUserFragment {
        return EditUserFragment()
    }
}