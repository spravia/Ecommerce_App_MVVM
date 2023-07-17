package com.savasapp.ecommerceappmvvm.domain.useCase.auth

import com.savasapp.ecommerceappmvvm.domain.model.AuthResponse
import com.savasapp.ecommerceappmvvm.domain.repository.AuthRepository

class SaveSessionUseCase constructor(private val repository : AuthRepository) {

    suspend operator fun invoke(authResponse: AuthResponse) = repository.saveSession(authResponse)
}