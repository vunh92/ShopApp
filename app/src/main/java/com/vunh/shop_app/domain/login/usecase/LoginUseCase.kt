package com.vunh.shop_app.domain.login.usecase

import com.vunh.shop_app.data.common.utils.WrappedResponse
import com.vunh.shop_app.data.login.remote.dto.LoginRequest
import com.vunh.shop_app.data.login.remote.dto.LoginResponse
import com.vunh.shop_app.domain.login.LoginRepository
import com.vunh.shop_app.domain.login.entity.LoginEntity
import com.vunh.shop_app.domain.common.BaseResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val loginRepository: LoginRepository) {
    suspend fun invoke(loginRequest: LoginRequest): Flow<BaseResult<LoginEntity, WrappedResponse<LoginResponse>>> {
        return loginRepository.login(loginRequest)
    }
}