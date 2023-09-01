package com.savasapp.ecommerceappmvvm.domain.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.net.StandardProtocolFamily
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class Category(
    @SerializedName("id") val id : String? = null,
    @SerializedName("name") val name :  String,
    @SerializedName("description") val descripcion : String,
    @SerializedName("image") val image : String? = null

) : Serializable{
    fun toJson() : String = Gson().toJson(Category
        (
         id,
         name,
         descripcion,
          if(!image.isNullOrBlank()) URLEncoder.encode(image, StandardCharsets.UTF_8.toString()) else ""
         )
    )

        companion object{
            fun fromJson(data: String) : Category = Gson().fromJson(data, Category::class.java)

        }
}


