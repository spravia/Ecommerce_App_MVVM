package com.savasapp.ecommerceappmvvm.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.savasapp.ecommerceappmvvm.presentation.navigation.screen.RolesScreen
import com.savasapp.ecommerceappmvvm.presentation.screens.admin.home.AdminHomeScreen
import com.savasapp.ecommerceappmvvm.presentation.screens.client.home.ClientHomeScreen
import com.savasapp.ecommerceappmvvm.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.RolesNavGraph(navController: NavHostController){

    navigation(route = Graph.ROLES, startDestination = RolesScreen.Roles.route)
    {
        composable(route = RolesScreen.Roles.route){
            RolesScreen(navController)
        }

        composable(route = Graph.CLIENT){
            ClientHomeScreen()
        }
    }
}