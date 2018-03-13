package jp.local.yukichan.selfmanager2.data.datastore

import io.reactivex.Flowable
import jp.local.yukichan.selfmanager2.data.entity.MeasureInfoEntity

/**
 * Created by takamk2 on 18/03/13.
 *
 * The Edit Fragment of Base Class.
 */
interface MeasureInfoDataStore {

    fun measureInfoEntityList(): Flowable<List<MeasureInfoEntity>>

    fun insert(measureInfoEntity: MeasureInfoEntity)

    fun update(measureInfoEntity: MeasureInfoEntity)

    fun delete(measureInfoEntity: MeasureInfoEntity)
}