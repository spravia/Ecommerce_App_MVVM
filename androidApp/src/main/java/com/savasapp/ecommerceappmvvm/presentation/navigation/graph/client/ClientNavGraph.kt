package com.savasapp.ecommerceappmvvm.presentation.navigation.graph.client

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.savasapp.ecommerceappmvvm.presentation.navigation.Graph
import com.savasapp.ecommerceappmvvm.presentation.navigation.graph.profile.ProfileNavGraph
import com.savasapp.ecommerceappmvvm.presentation.navigation.screen.client.ClientScreen
import com.savasapp.ecommerceappmvvm.presentation.screens.client.home.category.list.ClientProductListScreen
import com.savasapp.ecommerceappmvvm.presentation.screens.client.home.product.list.ClienteCategoryListScreen
import com.savasapp.ecommerceappmvvm.presentation.screens.profile.info.ProfileScreen

@Composable
fun ClientNavGraph(navController: NavHostController){

    NavHost(navController = navController,
            route = Graph.CLIENT,
            startDestination = ClientScreen.ProductList.route)
    {
        composable(route = ClientScreen.ProductList.route){
            ClientProductListScreen()
        }

        composable(route = ClientScreen.CategoryList.route){
            ClienteCategoryListScreen()
        }

        composable(route = ClientScreen.Profile.route){
            ProfileScreen(navController=navController)
        }

        ProfileNavGraph(navController)
    }
}