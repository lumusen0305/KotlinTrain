package com.kotlin.baselibrary.injection.component

import android.app.Activity
import android.content.Context
import com.kotlin.baselibrary.injection.ActivityScope
import com.kotlin.baselibrary.injection.module.ActivityModule
import com.kotlin.baselibrary.injection.module.AppModule
import com.kotlin.baselibrary.injection.module.LifecycleProviderModule
import com.trello.rxlifecycle4.LifecycleProvider
import dagger.Component
import javax.inject.Singleton

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(ActivityModule::class,LifecycleProviderModule::class))
interface ActivityComponent {
    fun activity():Activity
    fun context():Context
    fun lifecycleProvider(): LifecycleProvider<*>
}