package jp.local.yukichan.selfmanager2.view.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import jp.local.yukichan.selfmanager2.R
import jp.local.yukichan.selfmanager2.domain.model.User
import jp.local.yukichan.selfmanager2.extension.isDouble
import jp.local.yukichan.selfmanager2.viewmodel.fragment.EditUserFragmentViewModel
import kotlinx.android.synthetic.main.fragment_edit_user.*
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import java.util.concurrent.TimeUnit

/**
 * ユーザ情報編集画面
 */
class EditUserFragment : Fragment() {

    lateinit var viewModel: EditUserFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_edit_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(EditUserFragmentViewModel::class.java)

        initEvents()
        initObservesForViewModel()
    }

    private fun initEvents() {
        RxTextView.textChanges(etName).subscribe {
            checkInput()
        }

        RxTextView.textChanges(etHeight).subscribe {
            checkInput()
        }

        RxView.clicks(btSave).throttleFirst(200, TimeUnit.MILLISECONDS).subscribe {
            btSave.isEnabled = false
            launch(UI) {
                async(CommonPool) { viewModel.save(createUser()) }.await()
                async(CommonPool) { viewModel.test() }.await()
            }
        }
    }

    private fun checkInput() {
        btSave.isEnabled = false
        var isValid = true
        val name = etName.text.toString()
        if (name.isEmpty()) {
            isValid = false
        }
        val height = etHeight.text.toString()
        if (height.isEmpty()) {
            isValid = false
        } else if (!height.isDouble()) {
            isValid = false
        }
        if (isValid) {
            btSave.isEnabled = true
        }
    }

    private fun initObservesForViewModel() {
        viewModel.user.observe(this, Observer {
            tvId.text = it?.id.toString()
            etName.setText(it?.name)
            etHeight.setText(it?.height.toString())
            Toast.makeText(activity, "update! $it", Toast.LENGTH_SHORT).show()
        })
        viewModel.measureInfo.observe(this, Observer {
            if (it != null) {
                val sb = StringBuffer()
                it.forEach { info ->
                    sb.append(info.id)
                    sb.append(" ")
                }
                Toast.makeText(this.activity, sb.toString(), Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun createUser(): User {
        val name = etName.text.toString()
        val height = etHeight.text.toString().toDouble()
        return User(1, name, height) // id is always 1
    }
}