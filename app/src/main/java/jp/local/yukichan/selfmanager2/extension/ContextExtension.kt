package jp.local.yukichan.selfmanager2.extension

import android.content.Context
import jp.local.yukichan.selfmanager2.CustomApplication

/**
 * Created by takamk2 on 18/03/14.
 *
 * The Edit Fragment of Base Class.
 */
fun Context.app() = this.applicationContext as CustomApplication
