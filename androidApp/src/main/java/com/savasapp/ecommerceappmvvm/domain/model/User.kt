package com.savasapp.ecommerceappmvvm.domain.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id") val id: String? = null,
    @SerializedName("nombres") val name : String,
    @SerializedName("apellidos") val lastname : String,
    @SerializedName("email") val email : String,
    @SerializedName("telefono") val phone: String,
    @SerializedName("password") val password : String,
    @SerializedName("roles") val roles : String
){
    fun toJson(): String = Gson().toJson(this)

    companion object {

        fun fromJson(data : String): User = Gson().fromJson(data, User::class.java)
    }

}
