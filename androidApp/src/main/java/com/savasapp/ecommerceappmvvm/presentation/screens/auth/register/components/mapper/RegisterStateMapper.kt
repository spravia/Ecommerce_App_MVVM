package com.savasapp.ecommerceappmvvm.presentation.screens.auth.register.components.mapper

import com.savasapp.ecommerceappmvvm.domain.model.User
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.register.components.RegisterState

fun RegisterState.toUser() : User {
    return User(
        id= 0,
        nombres = name,
        apellidos = lastName,
        telefono = phone,
        password = password,
        roles = "CLIENT"
    )
}