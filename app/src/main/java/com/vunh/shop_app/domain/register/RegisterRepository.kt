package com.vunh.shop_app.domain.register

import com.vunh.shop_app.data.common.utils.WrappedResponse
import com.vunh.shop_app.data.register.remote.dto.RegisterRequest
import com.vunh.shop_app.data.register.remote.dto.RegisterResponse
import com.vunh.shop_app.domain.common.BaseResult
import com.vunh.shop_app.domain.register.entity.RegisterEntity
import kotlinx.coroutines.flow.Flow

interface RegisterRepository {
    suspend fun register(registerRequest: RegisterRequest) : Flow<BaseResult<RegisterEntity, WrappedResponse<RegisterResponse>>>
}