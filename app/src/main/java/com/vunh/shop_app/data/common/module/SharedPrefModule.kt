package com.vunh.shop_app.data.common.module

import android.content.Context
import com.vunh.shop_app.data.common.utils.SharedPrefStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SharedPrefModule {

    @Provides
    fun provideSharedPref(@ApplicationContext context: Context) : SharedPrefStorage {
        return SharedPrefStorage(context)
    }
}