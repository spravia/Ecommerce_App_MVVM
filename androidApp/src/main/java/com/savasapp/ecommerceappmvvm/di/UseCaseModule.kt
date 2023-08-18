package com.savasapp.ecommerceappmvvm.di


import com.savasapp.ecommerceappmvvm.domain.repository.AuthRepository
import com.savasapp.ecommerceappmvvm.domain.repository.UserRepository
import com.savasapp.ecommerceappmvvm.domain.useCase.auth.AuthUseCase
import com.savasapp.ecommerceappmvvm.domain.useCase.auth.GetSessionDataUseCase
import com.savasapp.ecommerceappmvvm.domain.useCase.auth.LogOutUseCase
import com.savasapp.ecommerceappmvvm.domain.useCase.auth.LoginUseCase
import com.savasapp.ecommerceappmvvm.domain.useCase.auth.RegisterUseCase
import com.savasapp.ecommerceappmvvm.domain.useCase.auth.SaveSessionUseCase
import com.savasapp.ecommerceappmvvm.domain.useCase.users.UpdateUserUseCase
import com.savasapp.ecommerceappmvvm.domain.useCase.users.UsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

                                //Impl Interfaz          //DataClass         //Clase
    @Provides
    fun provideAuthCase(authRepository: AuthRepository) = AuthUseCase(
                             login = LoginUseCase(authRepository),
                             register = RegisterUseCase(authRepository) ,
                             saveSession = SaveSessionUseCase(authRepository),
                             getSessionData = GetSessionDataUseCase(authRepository),
                             logOut = LogOutUseCase(authRepository)
                    )


    @Provides
    fun provideUserCase(userRepository: UserRepository) = UsersUseCase(updateUser = UpdateUserUseCase(userRepository))


}