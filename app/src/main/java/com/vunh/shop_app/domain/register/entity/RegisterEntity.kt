package com.vunh.shop_app.domain.register.entity

data class RegisterEntity(
    var id : Int,
    var name: String,
    var email: String,
    var token: String
)