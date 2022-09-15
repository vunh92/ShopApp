package com.vunh.shop_app.data.register

import com.vunh.shop_app.data.common.module.NetworkModule
import com.vunh.shop_app.data.register.remote.api.RegisterApi
import com.vunh.shop_app.data.register.repository.RegisterRepositoryImpl
import com.vunh.shop_app.domain.register.RegisterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class RegisterModule {
    @Singleton
    @Provides
    fun provideRegisterApi(retrofit: Retrofit) : RegisterApi {
        return retrofit.create(RegisterApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRegisterRepository(registerApi: RegisterApi) : RegisterRepository {
        return RegisterRepositoryImpl(registerApi)
    }
}