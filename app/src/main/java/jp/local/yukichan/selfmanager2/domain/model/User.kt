package jp.local.yukichan.selfmanager2.domain.model

/**
 * ユーザ情報
 */
data class User(
        val id: Int,
        var name: String,
        var height: Double)