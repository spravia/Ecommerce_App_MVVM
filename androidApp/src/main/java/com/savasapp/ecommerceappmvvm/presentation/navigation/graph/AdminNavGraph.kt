package com.savasapp.ecommerceappmvvm.presentation.navigation.graph

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.savasapp.ecommerceappmvvm.presentation.navigation.Graph
import com.savasapp.ecommerceappmvvm.presentation.navigation.screen.AdminScreen
import com.savasapp.ecommerceappmvvm.presentation.screens.admin.category.list.AdminProductListScreen
import com.savasapp.ecommerceappmvvm.presentation.screens.admin.prodcut.list.AdminCategoryListScreen
import com.savasapp.ecommerceappmvvm.presentation.screens.profile.ProfileScreen

@Composable
fun AdminNavGraph(navController: NavHostController){

    NavHost(navController = navController,
            route = Graph.ADMIN,
            startDestination = AdminScreen.ProductList.route)
    {
        composable(route = AdminScreen.ProductList.route){
            AdminProductListScreen()
        }

        composable(route = AdminScreen.CategoryList.route){
            AdminCategoryListScreen()
        }

        composable(route = AdminScreen.Profile.route){
            ProfileScreen()
        }
    }
}