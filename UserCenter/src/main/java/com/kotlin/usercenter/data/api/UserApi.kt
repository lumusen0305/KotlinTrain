package com.kotlin.usercenter.data.api

import com.kotlin.baselibrary.data.protocol.BaseResp
import com.kotlin.usercenter.data.protocol.RegisterReq
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("userCenter/register")
    fun register(@Body req: RegisterReq): Observable<BaseResp<String>>
}