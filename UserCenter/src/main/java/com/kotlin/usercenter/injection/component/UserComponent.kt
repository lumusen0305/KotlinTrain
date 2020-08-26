package com.kotlin.usercenter.injection.component

import com.kotlin.usercenter.injection.module.UserModule
import com.kotlin.usercenter.ui.activity.RegisterActivity
import dagger.Component

@Component(modules = arrayOf(UserModule::class))
interface UserComponent {
    fun infect(activity:RegisterActivity)

}