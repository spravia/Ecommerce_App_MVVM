package com.savasapp.ecommerceappmvvm.di

import com.savasapp.ecommerceappmvvm.data.datastore.AuthDataStore
import com.savasapp.ecommerceappmvvm.data.repository.dataSource.AuthLocalDataSource
import com.savasapp.ecommerceappmvvm.data.repository.dataSourceImpl.AuthLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    fun provideAuthLocalDataSource(authDataStore: AuthDataStore) : AuthLocalDataSource = AuthLocalDataSourceImpl(authDataStore)

}