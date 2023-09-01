package com.savasapp.ecommerceappmvvm.presentation.navigation.graph.admin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.savasapp.ecommerceappmvvm.presentation.navigation.Graph
import com.savasapp.ecommerceappmvvm.presentation.navigation.screen.admin.AdminCategoryScreen
import com.savasapp.ecommerceappmvvm.presentation.screens.admin.category.create.AdminCategoryCreateSceen

fun NavGraphBuilder.AdminCategoryNavGraph(navController: NavHostController){

    navigation(route = Graph.ADMIN_CATEGORY,
               startDestination = AdminCategoryScreen.CategoryCreate.route)
    {
        composable(route = AdminCategoryScreen.CategoryCreate.route){
            AdminCategoryCreateSceen(navController)
        }

    }
}