package com.savasapp.ecommerceappmvvm.di

import com.savasapp.ecommerceappmvvm.core.Config
import com.savasapp.ecommerceappmvvm.data.service.AuthService
import com.savasapp.ecommerceappmvvm.data.service.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import javax.inject.Singleton

  //https://www.youtube.com/watch?v=KA0M0xqQ0F0

  //https://www.youtube.com/watch?v=kKWYaQgu1Lw
@Module
@InstallIn( SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {

        return Retrofit
            .Builder()
            .baseUrl(Config.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit) : AuthService {
        return retrofit.create(AuthService::class.java)
    }


      @Provides
      @Singleton
      fun provideUsersService(retrofit: Retrofit) : UserService {
          return retrofit.create(UserService::class.java)
      }

}