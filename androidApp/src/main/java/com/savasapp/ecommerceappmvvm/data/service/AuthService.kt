package com.savasapp.ecommerceappmvvm.data.service

import android.service.autofill.UserData
import com.savasapp.ecommerceappmvvm.domain.model.AuthResponse
import com.savasapp.ecommerceappmvvm.domain.model.RegisterResponse
import com.savasapp.ecommerceappmvvm.domain.model.User
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.LoginState
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


interface AuthService {

    //     https://localhost:7109/api/users

    @POST("api/users")
    @Headers("Content-Type:application/json; charset=utf-8")
    suspend fun login(@Body loginData : LoginState): Response<AuthResponse>


    @POST("api/users/adduser")
    @Headers("Content-Type:application/json; charset=utf-8")
    suspend fun register(@Body user : User): Response<RegisterResponse>

}

       //@FormUrlEncoded
       //@Headers( "Accept: application/json" )
       // @Field("email") email: String,
       // @Field("password") password: String



