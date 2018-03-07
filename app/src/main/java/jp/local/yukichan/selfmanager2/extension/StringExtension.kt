package jp.local.yukichan.selfmanager2.extension

/**
 * Created by takamk2 on 18/03/08.
 *
 * The Edit Fragment of Base Class.
 */
fun String.isDouble(): Boolean {
    return try {
        this.toDouble()
        true
    } catch (e: NumberFormatException) {
        false
    }
}
