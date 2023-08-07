package com.savasapp.ecommerceappmvvm.domain.model

data class Rol(
    val id : Int,
    val nombreRole: String? = null,
    val image: String? = null,
    val route: String? = null,
    val idUsuarioECommerce: Int? = null
)
