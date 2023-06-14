package com.savasapp.ecommerceappmvvm.presentation.screens.auth

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController

import com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.components.Login
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.components.LoginContent

@Composable
fun LoginScreen(navController: NavHostController) {
    
    Scaffold()
    { paddingValues ->
        LoginContent(navController = navController, paddingValues)
    }

    Login(navController = navController)

}