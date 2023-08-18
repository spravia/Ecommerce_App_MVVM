package com.savasapp.ecommerceappmvvm.domain.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("nombres") val name : String? = null,
    @SerializedName("apellidos") val lastname : String? = null,
    @SerializedName("telefono") val phone: String? = null,
    @SerializedName("correo") val mail : String? = null,
    @SerializedName("roles") val roles : String? = null
){
    fun toJson(): String = Gson().toJson(this)

    companion object {

        fun fromJson(data : String): AuthResponse = Gson().fromJson(data, AuthResponse::class.java)
    }

}
