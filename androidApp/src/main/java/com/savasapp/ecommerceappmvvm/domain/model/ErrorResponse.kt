package com.savasapp.ecommerceappmvvm.domain.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ErrorResponse(
 val contentType : String = "",
 val serializerSettings : String = "",
 val value : content
)


data class content(
  val message : String = "",
  val statusCode : Int = 500
  )