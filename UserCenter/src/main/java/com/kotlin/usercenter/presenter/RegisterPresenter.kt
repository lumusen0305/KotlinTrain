package com.kotlin.usercenter.presenter

import com.kotlin.baselibrary.presenter.BasePresenter
import com.kotlin.usercenter.presenter.view.RegisterView
import com.kotlin.usercenter.service.UserService
import com.kotlin.usercenter.service.impl.UserServiceImpl
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.subscribeBy

import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Named

class RegisterPresenter @Inject constructor(): BasePresenter<RegisterView>(){

    @Inject
    @field:[Named("service")]
    lateinit var userService:UserService

//    @Inject
//    @field:[Named("service2")]
//    lateinit var userService2:UserService

//    val userService = UserServiceImpl()
    //業務邏輯
    fun register(pwd:String,verifyCode:String){
        userService.register(pwd,verifyCode)
            .observeOn(AndroidSchedulers.mainThread())
            .compose(lifecycleProvider.bindToLifecycle())
            .subscribeOn(Schedulers.io())
            .subscribeBy(  // named arguments for lambda Subscribers
                onNext = {
                    if (it){
                        mView.onRegisterResult("註冊成功")
                    }
                },
                onError =  { it.printStackTrace() },
                onComplete = { println("Done!") }
            )
    }

//    fun register2(pwd:String,verifyCode:String){
//        userService2.register(pwd,verifyCode)
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .subscribeBy(  // named arguments for lambda Subscribers
//                onNext = {
//                    mView.onRegisterResult(it)
//                },
//                onError =  { it.printStackTrace() },
//                onComplete = { println("Done!") }
//            )
//    }
}