package com.kotlin.usercenter.service.impl

import com.kotlin.baselibrary.data.protocol.BaseResp
import com.kotlin.baselibrary.rx.BaseException
import com.kotlin.usercenter.data.repository.UserRepository
import com.kotlin.usercenter.service.UserService
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.Function

open class UserServiceImpl :UserService {
    override fun register(pwd: String, verifyCode: String): Observable<Boolean> {
        val responsitory=UserRepository()
        return responsitory.register(pwd,verifyCode)
            .flatMap(object :Function<BaseResp<String>,Observable<Boolean>>{
                override fun apply(t: BaseResp<String>): Observable<Boolean> {
                   if(t.status != 0){
                       return Observable.error(BaseException(t.status,t.msg))
                   }
                    return Observable.just(true)
                }

            })
    }
}
