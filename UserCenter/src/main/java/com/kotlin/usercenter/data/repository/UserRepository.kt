package com.kotlin.usercenter.data.repository

import com.kotlin.baselibrary.data.net.RetrofitFactory
import com.kotlin.baselibrary.data.protocol.BaseResp
import com.kotlin.usercenter.data.api.UserApi
import com.kotlin.usercenter.data.protocol.RegisterReq
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class UserRepository @Inject constructor(){
    fun register(pwd:String,verifyCode:String): Observable<BaseResp<String>>{
        return RetrofitFactory.instance.create(UserApi::class.java)
            .register(RegisterReq(pwd,verifyCode))
    }

}