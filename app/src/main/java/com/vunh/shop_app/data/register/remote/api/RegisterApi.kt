package com.vunh.shop_app.data.register.remote.api

import com.vunh.shop_app.data.common.utils.WrappedResponse
import com.vunh.shop_app.data.register.remote.dto.RegisterRequest
import com.vunh.shop_app.data.register.remote.dto.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterApi {
    @POST("auth/register")
    suspend fun register(@Body registerRequest: RegisterRequest) : Response<WrappedResponse<RegisterResponse>>
}