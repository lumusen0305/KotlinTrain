package com.kotlin.usercenter.service.impl

import com.kotlin.baselibrary.data.protocol.BaseResp
import com.kotlin.baselibrary.rx.BaseException
import com.kotlin.baselibrary.rx.BaseFuncBoolean
import com.kotlin.usercenter.data.repository.UserRepository
import com.kotlin.usercenter.service.UserService
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.Function
import javax.inject.Inject

open class UserServiceImpl @Inject constructor():UserService {
    //讓它自己實例化
    @Inject
    lateinit var repository: UserRepository

    override fun register(pwd: String, verifyCode: String): Observable<Boolean> {
        return repository.register(pwd,verifyCode)
            .flatMap(BaseFuncBoolean())
    }
}
