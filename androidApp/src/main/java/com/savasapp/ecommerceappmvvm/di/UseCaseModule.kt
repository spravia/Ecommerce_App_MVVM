package com.savasapp.ecommerceappmvvm.di


import com.savasapp.ecommerceappmvvm.domain.repository.AuthRepository
import com.savasapp.ecommerceappmvvm.domain.useCase.auth.AuthUseCase
import com.savasapp.ecommerceappmvvm.domain.useCase.auth.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

                                //Impl Interfaz          //DataClass         //Clase
    @Provides
    fun provideAuthCase(authRepository: AuthRepository) = AuthUseCase(login = LoginUseCase(authRepository))

}