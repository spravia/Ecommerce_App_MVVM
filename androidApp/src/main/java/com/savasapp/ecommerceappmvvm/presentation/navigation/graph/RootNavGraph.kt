package com.savasapp.ecommerceappmvvm.presentation.navigation.graph

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.savasapp.ecommerceappmvvm.presentation.navigation.AuthNavGraph
import com.savasapp.ecommerceappmvvm.presentation.navigation.Graph
import com.savasapp.ecommerceappmvvm.presentation.navigation.RolesNavGraph
import com.savasapp.ecommerceappmvvm.presentation.screens.client.home.ClientHomeScreen

@Composable
fun RootNavGraph(navController: NavHostController){

    NavHost(navController = navController,
            route = Graph.ROOT,
            startDestination = Graph.AUTH)
    {
        AuthNavGraph(navController = navController)
        RolesNavGraph(navController = navController)
    }
}