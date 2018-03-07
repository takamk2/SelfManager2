package jp.local.yukichan.selfmanager2.extension

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

fun AppCompatActivity.showFragment(containerId: Int, fragment: Fragment) {
    supportFragmentManager.beginTransaction().apply {
        add(containerId, fragment, fragment::class.java.simpleName)
        commit()
    }
}

