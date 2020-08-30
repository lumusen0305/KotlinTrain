package com.kotlin.baselibrary.ui.fragment

import android.os.Bundle
import com.kotlin.baselibrary.common.BaseApplication
import com.kotlin.baselibrary.injection.component.ActivityComponent
import com.kotlin.baselibrary.injection.component.DaggerActivityComponent
import com.kotlin.baselibrary.injection.module.ActivityModule
import com.kotlin.baselibrary.injection.module.LifecycleProviderModule
import com.kotlin.baselibrary.presenter.BasePresenter
import com.kotlin.baselibrary.presenter.view.BaseView
import javax.inject.Inject

open abstract class BaseMVPFragment<T:BasePresenter<*>>: BaseFragment() ,BaseView{
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

    lateinit var activityComponent :ActivityComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        injectComponent()
        initActivityInjection()
    }

    abstract fun injectComponent()

    private fun initActivityInjection() {
        activityComponent=DaggerActivityComponent.builder().appComponent((activity!!.application as BaseApplication).appComponent).activityModule(
        ActivityModule(activity!!))
            .lifecycleProviderModule(LifecycleProviderModule(this))
            .build()        
    }
}