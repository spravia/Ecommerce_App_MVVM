package com.savasapp.ecommerceappmvvm.data.repository.dataSource

import com.savasapp.ecommerceappmvvm.domain.model.User
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.components.LoginState
import retrofit2.Response

interface AuthRemoteDataSource {

    suspend fun login(loginData : LoginState  ) : Response<User>

}