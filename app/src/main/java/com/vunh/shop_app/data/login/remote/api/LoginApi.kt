package com.vunh.shop_app.data.login.remote.api

import com.vunh.shop_app.data.common.utils.WrappedResponse
import com.vunh.shop_app.data.login.remote.dto.LoginRequest
import com.vunh.shop_app.data.login.remote.dto.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {
    @POST("auth/login")
    suspend fun login(@Body loginRequest: LoginRequest) : Response<WrappedResponse<LoginResponse>>
}