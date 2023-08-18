package com.savasapp.ecommerceappmvvm.presentation.screens.client.home.components

import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.savasapp.ecommerceappmvvm.presentation.navigation.screen.client.ClientScreen

@Composable
fun ClientBottomBar(navController: NavHostController){

    val screens = listOf(
        ClientScreen.CategoryList,
        ClientScreen.ProductList,
        ClientScreen.Profile    )

    val navBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackEntry?.destination
    val bottomBarDestination = screens.any { it.route == currentDestination?.route}

    if (bottomBarDestination){
        BottomNavigation() {
            screens.forEach { screen ->
                ClienteBottomBarItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}