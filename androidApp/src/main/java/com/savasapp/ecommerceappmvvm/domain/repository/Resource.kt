package com.savasapp.ecommerceappmvvm.domain.repository

import kotlin.Exception

sealed class Resource<out T>{

    object Loading : Resource<Nothing>()
    data class Success<out T>(val data : T) : Resource<T>()
    data class Failure<out T>(val message: String) : Resource<T>()

}
