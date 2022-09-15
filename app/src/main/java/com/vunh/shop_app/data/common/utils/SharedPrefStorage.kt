package com.vunh.shop_app.data.common.utils

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPrefStorage @Inject constructor(
    @ApplicationContext context: Context
) : Storage {
    companion object {
        private const val PREF = "LoginStorage"
        private const val PREF_TOKEN = "user_token"
    }

    private val sharedPreferences = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)

    override fun setString(key: String, value: String) {
        with(sharedPreferences.edit()) {
            putString(key, value)
            apply()
        }
    }

    override fun getString(key: String): String {
        return sharedPreferences.getString(key, "")!!
    }

    fun saveToken(token: String){
        put(PREF_TOKEN, token)
    }

    fun getToken() : String {
        return get(PREF_TOKEN, String::class.java)
    }

    private fun <T> get(key: String, clazz: Class<T>): T =
        when (clazz) {
            String::class.java -> sharedPreferences.getString(key, "")
            Boolean::class.java -> sharedPreferences.getBoolean(key, false)
            Float::class.java -> sharedPreferences.getFloat(key, -1f)
            Double::class.java -> sharedPreferences.getFloat(key, -1f)
            Int::class.java -> sharedPreferences.getInt(key, -1)
            Long::class.java -> sharedPreferences.getLong(key, -1L)
            else -> null
        } as T

    private fun <T> put(key: String, data: T) {
        val editor = sharedPreferences.edit()
        when (data) {
            is String -> editor.putString(key, data)
            is Boolean -> editor.putBoolean(key, data)
            is Float -> editor.putFloat(key, data)
            is Double -> editor.putFloat(key, data.toFloat())
            is Int -> editor.putInt(key, data)
            is Long -> editor.putLong(key, data)
        }
        editor.apply()
    }

    fun clear() {
        sharedPreferences.edit().run {
            remove(PREF_TOKEN)
        }.apply()
    }
}