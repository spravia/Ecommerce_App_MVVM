package com.savasapp.ecommerceappmvvm.di


import com.savasapp.ecommerceappmvvm.data.repository.AuthRepositoryImpl
import com.savasapp.ecommerceappmvvm.data.repository.dataSource.AuthLocalDataSource
import com.savasapp.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.savasapp.ecommerceappmvvm.data.service.AuthService
import com.savasapp.ecommerceappmvvm.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(authRemoteDataSource: AuthRemoteDataSource,
                              authLocalDataSource: AuthLocalDataSource) : AuthRepository = AuthRepositoryImpl(authRemoteDataSource, authLocalDataSource)

}