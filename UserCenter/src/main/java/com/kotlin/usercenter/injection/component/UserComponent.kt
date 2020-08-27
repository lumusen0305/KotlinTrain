package com.kotlin.usercenter.injection.component

import com.kotlin.baselibrary.injection.PerComponentScope
import com.kotlin.baselibrary.injection.component.ActivityComponent
import com.kotlin.usercenter.injection.module.UserModule
import com.kotlin.usercenter.ui.activity.RegisterActivity
import dagger.Component
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(UserModule::class))
interface UserComponent {
    fun inject(activity:RegisterActivity)

}