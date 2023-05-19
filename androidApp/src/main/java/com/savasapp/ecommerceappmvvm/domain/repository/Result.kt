package com.savasapp.ecommerceappmvvm.domain.repository

import kotlin.Exception

sealed class Result<out T>{

    object Loading : Result<Nothing>()
    data class Success<out T>(val data : T) : Result<T>()
    data class Failure<out T>(val exception: Exception) : Result<T>()

}
