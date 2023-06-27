package com.savasapp.ecommerceappmvvm.domain.useCase.auth

import javax.inject.Inject

data class AuthUseCase @Inject constructor( val login : LoginUseCase,  val register : RegisterUseCase    )
