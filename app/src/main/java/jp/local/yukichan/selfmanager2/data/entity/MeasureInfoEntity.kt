package jp.local.yukichan.selfmanager2.data.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "measure_info")
data class MeasureInfoEntity(var weight: Double) {
    @PrimaryKey(autoGenerate = true) var id: Int? = null
}
