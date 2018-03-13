package jp.local.yukichan.selfmanager2.data.datastore.internal.room.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import jp.local.yukichan.selfmanager2.data.datastore.internal.room.dao.MeasureInfoDao
import jp.local.yukichan.selfmanager2.data.entity.MeasureInfoEntity

@Database(entities = [MeasureInfoEntity::class], version = 2)
abstract class MyDatabase: RoomDatabase() {
    companion object {
        const val DB_NAME = "self_manager.db"
    }
    abstract fun measureInfoDao(): MeasureInfoDao
}

