package com.kotlin.baselibrary.presenter

import com.kotlin.baselibrary.presenter.view.BaseView
import com.trello.rxlifecycle4.LifecycleProvider
import javax.inject.Inject

open class BasePresenter<T:BaseView> {
    lateinit var mView:T
    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>
}