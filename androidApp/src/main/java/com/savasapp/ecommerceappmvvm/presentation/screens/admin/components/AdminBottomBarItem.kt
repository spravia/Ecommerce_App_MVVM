package com.savasapp.ecommerceappmvvm.presentation.screens.client.home.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.savasapp.ecommerceappmvvm.presentation.navigation.screen.admin.AdminScreen


@Composable
fun RowScope.AdminBottomBarItem(
    screen: AdminScreen,
    currentDestination : NavDestination?,
    navController: NavController
){

    BottomNavigationItem(
        selected = currentDestination?.hierarchy?.any() {it.route == screen.route} == true,
        onClick = { navController.navigate(route = screen.route){popUpTo( navController.graph.findStartDestination().id)}  },
        icon = { Icon(imageVector = screen.icon, contentDescription = "" ) },
        label = { Text(text = screen.title) },
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        )
}