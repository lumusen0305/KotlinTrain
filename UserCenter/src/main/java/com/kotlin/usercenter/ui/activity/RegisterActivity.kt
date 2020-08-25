package com.kotlin.usercenter.ui.activity
import android.os.Bundle
import com.kotlin.baselibrary.ui.activity.BaseMVPActivity
import com.kotlin.usercenter.R
import com.kotlin.usercenter.presenter.RegisterPresenter
import com.kotlin.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

class RegisterActivity : BaseMVPActivity<RegisterPresenter>(),RegisterView {
    override fun onRegisterResult(result: Boolean) {
        toast("註冊成功")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        btn_click.setOnClickListener{
            mPresenter= RegisterPresenter()
            mPresenter.mView=this
            mPresenter.register(" "," ")
        }
    }
}