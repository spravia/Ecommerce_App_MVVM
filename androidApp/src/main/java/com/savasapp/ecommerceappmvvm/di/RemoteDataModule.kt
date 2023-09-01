package com.savasapp.ecommerceappmvvm.di

import AuthRemoteDataSourceImpl
import CategoriesRemoteDataSourceImpl
import UsersRemoteDataSourceImpl
import com.savasapp.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.savasapp.ecommerceappmvvm.data.repository.dataSource.CategoriesRemoteDataSource
import com.savasapp.ecommerceappmvvm.data.repository.dataSource.UsersRemoteDataSource
import com.savasapp.ecommerceappmvvm.data.service.AuthService
import com.savasapp.ecommerceappmvvm.data.service.CategoryService
import com.savasapp.ecommerceappmvvm.data.service.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Provides
    fun provideAuthRemoteDataSource(authService: AuthService) : AuthRemoteDataSource = AuthRemoteDataSourceImpl(authService)

    @Provides
    fun provideUsersRemoteDataSource(userService: UserService) : UsersRemoteDataSource = UsersRemoteDataSourceImpl(userService)


    @Provides
    fun provideCategoryRemoteDataSource(categoryService: CategoryService) : CategoriesRemoteDataSource =CategoriesRemoteDataSourceImpl(categoryService)

}