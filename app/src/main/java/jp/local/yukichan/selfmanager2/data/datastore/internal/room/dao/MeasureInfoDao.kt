package jp.local.yukichan.selfmanager2.data.datastore.internal.room.dao

import android.arch.persistence.room.*
import io.reactivex.Flowable
import jp.local.yukichan.selfmanager2.data.entity.MeasureInfoEntity

@Dao
interface MeasureInfoDao {

    @Query("SELECT * FROM measure_info")
    fun getAll(): Flowable<List<MeasureInfoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg measureInfoEntity: MeasureInfoEntity)

    @Update
    fun update(vararg measureInfoEntity: MeasureInfoEntity)

    @Delete
    fun delete(vararg measureInfoEntity: MeasureInfoEntity)
}