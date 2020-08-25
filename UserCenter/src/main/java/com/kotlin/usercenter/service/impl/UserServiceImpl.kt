package com.kotlin.usercenter.service.impl

import com.kotlin.usercenter.service.UserService
import io.reactivex.rxjava3.core.Observable

class UserServiceImpl :UserService {
    override fun register(pwd: String, vertifyCode: String): Observable<Boolean> {
        return Observable.just(true)
    }
}
