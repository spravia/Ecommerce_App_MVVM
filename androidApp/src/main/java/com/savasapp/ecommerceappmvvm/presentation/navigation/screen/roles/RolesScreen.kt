package com.savasapp.ecommerceappmvvm.presentation.navigation.screen.roles

sealed class RolesScreen(val route : String){
    object Roles : RolesScreen("roles")

}
