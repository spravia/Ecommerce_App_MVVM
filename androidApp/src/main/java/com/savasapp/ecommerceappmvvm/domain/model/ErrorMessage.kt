package com.savasapp.ecommerceappmvvm.domain.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ErrorMessage(
  val errorcode: Int = 500,
  val errorDesc : String? = ""
)
