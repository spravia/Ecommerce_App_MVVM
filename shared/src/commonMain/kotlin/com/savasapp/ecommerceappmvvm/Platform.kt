package com.savasapp.ecommerceappmvvm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform