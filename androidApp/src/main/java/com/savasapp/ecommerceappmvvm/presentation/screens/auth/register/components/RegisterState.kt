package com.savasapp.ecommerceappmvvm.presentation.screens.auth.register.components

data class RegisterState(
    val name: String = "",
    val lastName : String = "",
    val email : String = "",
    val phone : String = "",
    val password : String = "",
    val confimPassword : String = ""
)
