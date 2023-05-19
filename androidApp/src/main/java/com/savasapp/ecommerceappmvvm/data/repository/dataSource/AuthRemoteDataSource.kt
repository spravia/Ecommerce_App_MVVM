package com.savasapp.ecommerceappmvvm.data.repository.dataSource

import com.savasapp.ecommerceappmvvm.domain.model.User
import retrofit2.Response

interface AuthRemoteDataSource {

    suspend fun login(mail:String, password: String) : Response<User>

}