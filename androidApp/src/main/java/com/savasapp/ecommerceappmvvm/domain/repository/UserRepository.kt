package com.savasapp.ecommerceappmvvm.domain.repository

import com.savasapp.ecommerceappmvvm.domain.model.User

interface UserRepository {

    suspend fun update(user : User) : Resource<User>

}