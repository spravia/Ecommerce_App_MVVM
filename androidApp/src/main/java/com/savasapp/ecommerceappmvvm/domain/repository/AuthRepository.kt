package com.savasapp.ecommerceappmvvm.domain.repository

import com.savasapp.ecommerceappmvvm.domain.model.User

interface AuthRepository{

    suspend fun login(email: String, password : String):  Result<User>

}