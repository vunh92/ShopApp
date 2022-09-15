package com.vunh.shop_app.data.register.repository

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vunh.shop_app.data.common.utils.WrappedResponse
import com.vunh.shop_app.data.register.remote.api.RegisterApi
import com.vunh.shop_app.data.register.remote.dto.RegisterRequest
import com.vunh.shop_app.data.register.remote.dto.RegisterResponse
import com.vunh.shop_app.domain.common.BaseResult
import com.vunh.shop_app.domain.register.RegisterRepository
import com.vunh.shop_app.domain.register.entity.RegisterEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RegisterRepositoryImpl @Inject constructor(private val registerApi: RegisterApi) :
    RegisterRepository {
    override suspend fun register(registerRequest: RegisterRequest): Flow<BaseResult<RegisterEntity, WrappedResponse<RegisterResponse>>> {
        return flow {
            val response = registerApi.register(registerRequest)
            if (response.isSuccessful){
                val body = response.body()!!
                val registerEntity = RegisterEntity(body.data?.id!!, body.data?.name!!, body.data?.email!!, body.data?.token!!)
                emit(BaseResult.Success(registerEntity))
            }else{
                val type = object : TypeToken<WrappedResponse<RegisterResponse>>(){}.type
                val err : WrappedResponse<RegisterResponse> = Gson().fromJson(response.errorBody()!!.charStream(), type)
                err.code = response.code()
                emit(BaseResult.Error(err))
            }
        }
    }
}