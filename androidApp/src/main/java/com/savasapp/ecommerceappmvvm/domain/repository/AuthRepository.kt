package com.savasapp.ecommerceappmvvm.domain.repository

import com.savasapp.ecommerceappmvvm.domain.model.User
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.components.LoginState

interface AuthRepository{

        suspend fun login(loginData: LoginState ):  Result<User>

}