package com.savasapp.ecommerceappmvvm.di

import com.savasapp.ecommerceappmvvm.core.Config
import com.savasapp.ecommerceappmvvm.data.datastore.AuthDataStore
import com.savasapp.ecommerceappmvvm.data.service.AuthService
import com.savasapp.ecommerceappmvvm.data.service.CategoryService
import com.savasapp.ecommerceappmvvm.data.service.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

import javax.inject.Singleton

  //https://www.youtube.com/watch?v=KA0M0xqQ0F0

  //https://www.youtube.com/watch?v=kKWYaQgu1Lw
@Module
@InstallIn( SingletonComponent::class)
object NetworkModule {


                //TODO para agregar el token a la petición
      @Provides
      @Singleton
      fun provideOkHttpClient(dataStore:AuthDataStore) = OkHttpClient.Builder().addInterceptor{

          val token = runBlocking {
                                     dataStore.getData().first().name
              }

            val newRequest = it.request().newBuilder().addHeader("Auto", token?: "").build()

            it.proceed(newRequest)

      }.build()

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

      @Provides
      @Singleton
      fun provideCategoriesService(retrofit: Retrofit) : CategoryService {
          return retrofit.create(CategoryService::class.java)
      }


}