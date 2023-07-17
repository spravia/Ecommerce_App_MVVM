package com.savasapp.ecommerceappmvvm.domain.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("errorcode") val errorCode : Int? = null,
    @SerializedName("errorDesc") val errorDesc : String? = null
)
{
    fun toJson() : String = Gson().toJson(this)

    companion object {
        fun fromJson(data : String) : RegisterResponse = Gson().fromJson(data , RegisterResponse::class.java)
    }
}

