package com.kotlin.usercenter.ui.activity
import android.os.Bundle
import com.kotlin.baselibrary.ui.activity.BaseMVPActivity
import com.kotlin.usercenter.R
import com.kotlin.usercenter.injection.component.DaggerUserComponent
import com.kotlin.usercenter.injection.module.UserModule
import com.kotlin.usercenter.presenter.RegisterPresenter
import com.kotlin.usercenter.presenter.view.RegisterView
import dagger.android.DaggerActivity
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast
import javax.inject.Inject

class RegisterActivity : BaseMVPActivity<RegisterPresenter>(),RegisterView {
    override fun onRegisterResult(result: String) {
        toast(result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        injectComponent()
//        initInjection()


        btn_click.setOnClickListener{
            mPresenter.register(mPwdEt.text.toString(),mVerifyCodeEt.text.toString())
        }
//        mGetVerifyCode.setOnClickListener{
//            mPresenter.register2(mPwdEt.text.toString(),mVerifyCodeEt.text.toString())
//        }
    }

    private fun initInjection() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
            mPresenter.mView=this
    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView=this
    }


}