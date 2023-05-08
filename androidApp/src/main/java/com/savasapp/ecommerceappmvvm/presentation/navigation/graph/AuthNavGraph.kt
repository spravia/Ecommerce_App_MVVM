package com.savasapp.ecommerceappmvvm.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.savasapp.ecommerceappmvvm.presentation.navigation.screen.AuthScreen
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.LoginScreen
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.register.RegisterScreen

fun NavGraphBuilder.AuthNavGraph(navController: NavHostController){

    navigation(route = Graph.AUTH, startDestination = AuthScreen.Login.route){
        composable(route = AuthScreen.Login.route){
            LoginScreen(navController)
        }


        composable(route = AuthScreen.Register.route){
            RegisterScreen(navController)
        }
    }

}