package com.vunh.shop_app.domain.login

import com.vunh.shop_app.data.common.utils.WrappedResponse
import com.vunh.shop_app.data.login.remote.dto.LoginRequest
import com.vunh.shop_app.data.login.remote.dto.LoginResponse
import com.vunh.shop_app.domain.login.entity.LoginEntity
import com.vunh.shop_app.domain.common.BaseResult
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun login(loginRequest: LoginRequest) : Flow<BaseResult<LoginEntity, WrappedResponse<LoginResponse>>>
}