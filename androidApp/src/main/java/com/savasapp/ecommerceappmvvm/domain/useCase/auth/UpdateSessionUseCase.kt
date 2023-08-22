package com.savasapp.ecommerceappmvvm.domain.useCase.auth

import com.savasapp.ecommerceappmvvm.domain.model.AuthResponse
import com.savasapp.ecommerceappmvvm.domain.model.User
import com.savasapp.ecommerceappmvvm.domain.repository.AuthRepository

class UpdateSessionUseCase constructor(private val repository : AuthRepository) {

    suspend operator fun invoke(user: User) = repository.updateSession(user)

}