package com.kotlin.baselibrary.injection.module

import android.app.Activity
import android.content.Context
import com.trello.rxlifecycle4.LifecycleProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LifecycleProviderModule(private val lifecycleProvider: LifecycleProvider<*>) {
    @Provides
    fun provideslifecycleProvider():LifecycleProvider<*>{
        return lifecycleProvider
    }
}