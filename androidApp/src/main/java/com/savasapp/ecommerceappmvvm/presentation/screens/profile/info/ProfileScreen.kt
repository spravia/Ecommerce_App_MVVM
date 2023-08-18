package com.savasapp.ecommerceappmvvm.presentation.screens.profile.info

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.savasapp.ecommerceappmvvm.presentation.screens.profile.info.components.ProfileContent

@Composable
fun ProfileScreen(navController: NavHostController){

    Scaffold() {paddingValues ->
        ProfileContent(paddingValues = paddingValues, navController = navController)
    }

}