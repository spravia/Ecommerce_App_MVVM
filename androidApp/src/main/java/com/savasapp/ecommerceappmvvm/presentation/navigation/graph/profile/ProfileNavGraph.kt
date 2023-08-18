package com.savasapp.ecommerceappmvvm.presentation.navigation.graph.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.savasapp.ecommerceappmvvm.presentation.navigation.Graph
import com.savasapp.ecommerceappmvvm.presentation.navigation.screen.profile.ProfileScreen
import com.savasapp.ecommerceappmvvm.presentation.screens.profile.update.ProfileUpdateScreen
import com.savasapp.ecommerceappmvvm.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.ProfileNavGraph(navController: NavHostController){

    navigation(route = Graph.PROFILE + "/{user}",
               startDestination = ProfileScreen.ProfileUpdate.route)
    {
        composable(route = ProfileScreen.ProfileUpdate.route){
            RolesScreen(navController)
        }

        //TODO pasar parametro por NavController

        composable(route = ProfileScreen.ProfileUpdate.route,
                   arguments = listOf(navArgument("user"){
                       type = NavType.StringType
                   })
        ){ it ->
            it.arguments?.getString("user")?.let{
                ProfileUpdateScreen(navController = navController, userParam = it) 
            }

        }

    }
}