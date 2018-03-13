package jp.local.yukichan.selfmanager2.data.datastore.internal

import android.app.Application
import android.arch.persistence.room.Room
import io.reactivex.Flowable
import jp.local.yukichan.selfmanager2.data.datastore.MeasureInfoDataStore
import jp.local.yukichan.selfmanager2.data.datastore.internal.room.database.MyDatabase
import jp.local.yukichan.selfmanager2.data.entity.MeasureInfoEntity

class InternalMeasureInfoDataStore(application: Application): MeasureInfoDataStore {

    private val db: MyDatabase =
            Room.databaseBuilder(application, MyDatabase::class.java, MyDatabase.DB_NAME).build()

    override fun measureInfoEntityList(): Flowable<List<MeasureInfoEntity>> {
        return db.measureInfoDao().getAll()
    }

    override fun insert(measureInfoEntity: MeasureInfoEntity) {
        db.measureInfoDao().insert(measureInfoEntity)
    }

    override fun update(measureInfoEntity: MeasureInfoEntity) {
        db.measureInfoDao().update(measureInfoEntity)
    }

    override fun delete(measureInfoEntity: MeasureInfoEntity) {
        db.measureInfoDao().delete(measureInfoEntity)
    }

}

