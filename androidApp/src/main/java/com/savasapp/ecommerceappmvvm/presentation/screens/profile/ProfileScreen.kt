package com.savasapp.ecommerceappmvvm.presentation.screens.profile

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.savasapp.ecommerceappmvvm.presentation.screens.profile.components.ProfileContent

@Composable
fun ProfileScreen(){

    Scaffold() {paddingValues ->
        ProfileContent(paddingValues = paddingValues)
    }

}