package com.savasapp.ecommerceappmvvm.presentation.screens.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navHostController: NavHostController){

    Scaffold() {paddingValues ->
        Text(text = "HomeScreen", modifier = Modifier.padding(paddingValues = paddingValues))
    }

}