package com.savasapp.ecommerceappmvvm.data.repository.dataSource

import android.service.autofill.UserData
import com.savasapp.ecommerceappmvvm.domain.model.AuthResponse
import com.savasapp.ecommerceappmvvm.domain.model.RegisterResponse
import com.savasapp.ecommerceappmvvm.domain.model.User
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.LoginState
import retrofit2.Response

interface UsersRemoteDataSource {

    suspend fun update(user: User) : Response<User>

}