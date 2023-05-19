package com.savasapp.ecommerceappmvvm.data.repository

import com.savasapp.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.savasapp.ecommerceappmvvm.domain.model.User
import com.savasapp.ecommerceappmvvm.domain.repository.AuthRepository
import com.savasapp.ecommerceappmvvm.domain.repository.Result

class AuthRepositoryImpl(private val authRemoteDataSource : AuthRemoteDataSource) : AuthRepository {

    override suspend fun login(email: String, password: String): Result<User> {
        return try {
            val result = authRemoteDataSource.login(email, password)
            Result.Success(result.body()!!)

        } catch (e : Exception) {

            e.printStackTrace()
            Result.Failure(e)
        }
    }
}