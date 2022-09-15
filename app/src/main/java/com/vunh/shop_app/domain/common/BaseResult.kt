package com.vunh.shop_app.domain.common

sealed class BaseResult<out T: Any, out U: Any> {
    class Success<T: Any>(val data: T) : BaseResult<T, Nothing>()
    class Error<U: Any>(val rawResponse: U) : BaseResult<Nothing, U>()
}