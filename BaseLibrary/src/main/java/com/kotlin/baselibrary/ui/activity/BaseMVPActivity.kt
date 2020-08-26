package com.kotlin.baselibrary.ui.activity

import com.kotlin.baselibrary.presenter.BasePresenter
import com.kotlin.baselibrary.presenter.view.BaseView
import javax.inject.Inject

open class BaseMVPActivity<T:BasePresenter<*>>: BaseActivity() ,BaseView{
    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hideLoading() {
        TODO("Not yet implemented")
    }

    override fun onError() {
        TODO("Not yet implemented")
    }
    @Inject
    lateinit var mPresenter:T
}