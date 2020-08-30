package com.kotlin.baselibrary.ext

import com.kotlin.baselibrary.rx.BaseSubscriber
import com.trello.rxlifecycle4.LifecycleProvider
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers

fun <T : Any> Observable<T>.execute(lifecycleProvider: LifecycleProvider<*>){
    this.observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribeBy(
            onNext = {
            },
            onError =  { it.printStackTrace() },
            onComplete = { println("Done!") }
        )

}