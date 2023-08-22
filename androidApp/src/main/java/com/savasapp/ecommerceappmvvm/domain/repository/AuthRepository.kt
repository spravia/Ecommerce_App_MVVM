package com.savasapp.ecommerceappmvvm.domain.repository

import com.savasapp.ecommerceappmvvm.domain.model.AuthResponse
import com.savasapp.ecommerceappmvvm.domain.model.RegisterResponse
import com.savasapp.ecommerceappmvvm.domain.model.User
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.LoginState
import kotlinx.coroutines.flow.Flow

interface AuthRepository{

        suspend fun login(loginData: LoginState):  Resource<AuthResponse>

        suspend fun register(user : User ) : Resource<RegisterResponse>

        suspend fun saveSession(authResponse: AuthResponse)

        suspend fun updateSession(user: User)

        fun getSessionData() : Flow<AuthResponse>

        suspend fun logOut()
}