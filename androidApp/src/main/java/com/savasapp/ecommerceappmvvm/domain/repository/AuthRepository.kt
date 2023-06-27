package com.savasapp.ecommerceappmvvm.domain.repository

import com.savasapp.ecommerceappmvvm.domain.model.AuthResponse
import com.savasapp.ecommerceappmvvm.domain.model.User
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.LoginState

interface AuthRepository{

        suspend fun login(loginData: LoginState):  Resource<AuthResponse>

        suspend fun register(user : User ) : Resource<AuthResponse>

}