package com.savasapp.ecommerceappmvvm.data.repository.dataSource

import com.savasapp.ecommerceappmvvm.domain.model.AuthResponse
import com.savasapp.ecommerceappmvvm.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthLocalDataSource {

    suspend fun saveSession(authResponse: AuthResponse)
    suspend fun updateSession(user: User)

    fun getSessionData() : Flow<AuthResponse>
    suspend fun logout()

}