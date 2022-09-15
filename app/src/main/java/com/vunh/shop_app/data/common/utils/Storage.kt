package com.vunh.shop_app.data.common.utils

interface Storage {
    fun setString(key: String, value: String)
    fun getString(key: String): String
}