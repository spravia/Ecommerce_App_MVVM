package com.savasapp.ecommerceappmvvm.presentation.screens.roles

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.savasapp.ecommerceappmvvm.presentation.components.DefaultTopAppBar
import com.savasapp.ecommerceappmvvm.presentation.screens.roles.components.RolesContent

@Composable
fun RolesScreen(navController: NavHostController){

    Scaffold (
               topBar = { DefaultTopAppBar(title = "Seleccionar rol",  upAvailable = true , navController = navController ) }
    )
    { paddingValues ->
        RolesContent(paddingValues, navController)
    }
}