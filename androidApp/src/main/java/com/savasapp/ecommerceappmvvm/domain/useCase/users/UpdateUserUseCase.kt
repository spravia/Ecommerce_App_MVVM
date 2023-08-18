package com.savasapp.ecommerceappmvvm.domain.useCase.users

import com.savasapp.ecommerceappmvvm.domain.model.User
import com.savasapp.ecommerceappmvvm.domain.repository.UserRepository

class UpdateUserUseCase(private val repository: UserRepository){
    suspend operator fun invoke(user: User) = repository.update(user)
}