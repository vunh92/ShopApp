package com.vunh.shop_app.data.common.utils

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class RequestInterceptor @Inject constructor(private val pref: SharedPrefStorage) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = pref.getToken()
        val newRequest = chain.request().newBuilder()
            .addHeader("Authorization", token)
            .build()
        return chain.proceed(newRequest)
    }
}