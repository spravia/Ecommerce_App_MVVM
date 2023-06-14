package com.savasapp.ecommerceappmvvm.domain.useCase.auth

import com.savasapp.ecommerceappmvvm.domain.repository.AuthRepository
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.LoginState

class LoginUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(loginData : LoginState) = repository.login( loginData  )

}