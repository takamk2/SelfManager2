package jp.local.yukichan.selfmanager2.di.component

import dagger.Component
import jp.local.yukichan.selfmanager2.di.module.ActivityModule
import jp.local.yukichan.selfmanager2.view.activity.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)
}