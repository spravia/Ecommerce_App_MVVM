package com.savasapp.ecommerceappmvvm.domain.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id") val id: Int,
    @SerializedName("nombres") var nombres: String,
    @SerializedName("apellidos") var apellidos: String,
    @SerializedName("email") var email: String? = null,
    @SerializedName("telefono") var telefono: String,
    @SerializedName("password") val password: String? = null,
    @SerializedName("roles") val roles: String? = null
) {
    fun toJson(): String = Gson().toJson(this)

    companion object {
        fun fromJson(data: String): User = Gson().fromJson(data, User::class.java)
    }
}