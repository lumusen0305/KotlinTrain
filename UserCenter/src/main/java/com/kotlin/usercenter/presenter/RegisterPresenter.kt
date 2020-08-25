package com.kotlin.usercenter.presenter

import com.kotlin.baselibrary.presenter.BasePresenter
import com.kotlin.usercenter.presenter.view.RegisterView
import com.kotlin.usercenter.service.UserService
import com.kotlin.usercenter.service.impl.UserServiceImpl
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.subscribeBy

import io.reactivex.rxjava3.schedulers.Schedulers

class RegisterPresenter : BasePresenter<RegisterView>(){
    val userService = UserServiceImpl()
    //業務邏輯
    fun register(pwd:String,verifyCode:String){
        userService.register(pwd,verifyCode)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeBy(  // named arguments for lambda Subscribers
                onNext = { println("====it====="+it)
                mView.onRegisterResult(it)
                },
                onError =  { it.printStackTrace() },
                onComplete = { println("Done!") }
            )
    }
}