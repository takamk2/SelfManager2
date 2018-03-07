package jp.local.yukichan.selfmanager2.viewmodel.fragment

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import jp.local.yukichan.selfmanager2.domain.model.User
import kotlinx.coroutines.experimental.delay

class EditUserFragmentViewModel(application: Application) : AndroidViewModel(application) {

    val user = MutableLiveData<User>()

    fun getUser() {
    }

    suspend fun save(user: User) {
        delay(1000)
        this.user.postValue(user)
    }
}