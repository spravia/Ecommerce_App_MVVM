package com.savasapp.ecommerceappmvvm.data.service

import com.savasapp.ecommerceappmvvm.domain.model.User
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.POST

interface AuthService {

    @POST("auth/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<User>

}