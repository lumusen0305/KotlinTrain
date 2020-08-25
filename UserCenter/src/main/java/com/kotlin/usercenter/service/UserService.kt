package com.kotlin.usercenter.service

import io.reactivex.rxjava3.core.Observable

interface UserService {
    fun register(pwd:String,verifyCode:String): Observable<Boolean>
}