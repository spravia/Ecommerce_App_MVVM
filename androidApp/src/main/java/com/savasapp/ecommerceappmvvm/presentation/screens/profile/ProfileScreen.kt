package com.savasapp.ecommerceappmvvm.presentation.screens.profile

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.savasapp.ecommerceappmvvm.presentation.screens.profile.components.ProfileContent

@Composable
fun ProfileScreen(){

    Scaffold() {paddingValues ->
        ProfileContent(paddingValues = paddingValues)
    }

}