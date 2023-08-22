package com.savasapp.ecommerceappmvvm.data.service

import com.savasapp.ecommerceappmvvm.domain.model.AuthResponse
import com.savasapp.ecommerceappmvvm.domain.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.PUT
import retrofit2.http.Query


interface UserService {

    //     https://localhost:7109/users/{id}

    @PUT("api/users/updateuser")
    @Headers("Content-Type:application/json; charset=utf-8")
    suspend fun update(
        @Query("id") id :Int,
        @Body user: User
    ): Response<User>


}




