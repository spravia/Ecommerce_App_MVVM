package com.savasapp.ecommerceappmvvm.presentation.navigation.graph

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.savasapp.ecommerceappmvvm.presentation.navigation.AuthNavGraph
import com.savasapp.ecommerceappmvvm.presentation.navigation.Graph

@Composable
fun RootNavGraph(navController: NavHostController){

    NavHost(navController = navController,
            route = Graph.ROOT,
            startDestination = Graph.AUTH)
    {
        AuthNavGraph(navController = navController)
    }
}