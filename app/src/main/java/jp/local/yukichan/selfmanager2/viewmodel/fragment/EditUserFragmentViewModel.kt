package jp.local.yukichan.selfmanager2.viewmodel.fragment

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import jp.local.yukichan.selfmanager2.data.entity.MeasureInfoEntity
import jp.local.yukichan.selfmanager2.domain.model.User
import jp.local.yukichan.selfmanager2.extension.app
import kotlinx.coroutines.experimental.delay

class EditUserFragmentViewModel(application: Application) : AndroidViewModel(application) {

    val user = MutableLiveData<User>()

    val measureInfo = MutableLiveData<List<MeasureInfoEntity>>()
    val measureInfoDataStore = application.app().measureInfoDataStore

    init {
        measureInfoDataStore.measureInfoEntityList().subscribe {
            measureInfo.postValue(it)
        }
    }

    suspend fun save(user: User) {
        delay(1000)
        this.user.postValue(user)
    }

    suspend fun test() {
        val measureInfoEntity = MeasureInfoEntity(73.5)
        measureInfoDataStore.insert(measureInfoEntity)
    }
}