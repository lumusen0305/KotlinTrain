package com.kotlin.baselibrary.rx

import com.kotlin.baselibrary.data.protocol.BaseResp
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.Function

class BaseFunc <T>:Function<BaseResp<T>,Observable<T>>{
    override fun apply(t: BaseResp<T>): Observable<T> {
        if(t.status != 0){
            print("====="+t.status+t.msg+"====")
            return Observable.error(BaseException(t.status,t.msg))
        }
        return Observable.just(t.data)
    }
}