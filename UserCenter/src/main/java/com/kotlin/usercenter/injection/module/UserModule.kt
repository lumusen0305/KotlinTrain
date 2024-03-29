package com.kotlin.usercenter.injection.module

import com.kotlin.usercenter.service.UserService
import com.kotlin.usercenter.service.impl.UserServiceImpl
import com.kotlin.usercenter.service.impl.UserServiceImpl2
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class UserModule {
    @Provides
    @Named("service")
    fun providesUserService(service :UserServiceImpl) :UserService{
        return service
    }

    @Provides
    @Named("service2")
    fun providesUserService2(service : UserServiceImpl2) :UserService{
        return service
    }
}