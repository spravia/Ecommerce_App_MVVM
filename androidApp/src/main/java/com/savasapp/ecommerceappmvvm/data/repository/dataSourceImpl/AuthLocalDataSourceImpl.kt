package com.savasapp.ecommerceappmvvm.data.repository.dataSourceImpl

import com.savasapp.ecommerceappmvvm.data.datastore.AuthDataStore
import com.savasapp.ecommerceappmvvm.data.repository.dataSource.AuthLocalDataSource
import com.savasapp.ecommerceappmvvm.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor(private val authDataStore: AuthDataStore) : AuthLocalDataSource {

    override suspend fun saveSession(authResponse: AuthResponse) = authDataStore.saveUser(authResponse)

    override fun getSessionData(): Flow<AuthResponse> = authDataStore.getData()
    override suspend fun logout() = authDataStore.delete()

}