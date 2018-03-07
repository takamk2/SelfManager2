package jp.local.yukichan.selfmanager2.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import jp.local.yukichan.selfmanager2.R
import jp.local.yukichan.selfmanager2.di.component.ActivityComponent
import jp.local.yukichan.selfmanager2.di.component.DaggerActivityComponent
import jp.local.yukichan.selfmanager2.di.module.ActivityModule
import jp.local.yukichan.selfmanager2.extension.showFragment
import jp.local.yukichan.selfmanager2.view.fragment.EditUserFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var activityComponent: ActivityComponent

    @Inject
    lateinit var editUserFragment: EditUserFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this)).build().apply {
            inject(this@MainActivity)
        }

        showFragment(R.id.fragment_container, editUserFragment)
    }
}
