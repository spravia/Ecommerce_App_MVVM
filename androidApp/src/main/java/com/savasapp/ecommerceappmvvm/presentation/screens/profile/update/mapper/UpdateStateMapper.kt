package com.savasapp.ecommerceappmvvm.presentation.screens.profile.update.mapper

import com.savasapp.ecommerceappmvvm.domain.model.User
import com.savasapp.ecommerceappmvvm.presentation.screens.profile.update.components.ProfileUpdateState

     //TODO funcion de extension tomando como base una data class y retornando un objeto tipo USER

fun ProfileUpdateState.toUser(id: Int) : User
{
        return User(
            id = id,
            nombres = name,
            apellidos = lastName,
            telefono = phone
        )
}