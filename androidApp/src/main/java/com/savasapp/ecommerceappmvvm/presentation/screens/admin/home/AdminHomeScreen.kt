package com.savasapp.ecommerceappmvvm.presentation.screens.admin.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.savasapp.ecommerceappmvvm.presentation.navigation.graph.AdminNavGraph
import com.savasapp.ecommerceappmvvm.presentation.screens.client.home.components.AdminBottomBar
import com.savasapp.ecommerceappmvvm.presentation.screens.client.home.components.ClientBottomBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AdminHomeScreen(navHostController: NavHostController = rememberNavController() ) {

    Scaffold(
        bottomBar = { AdminBottomBar(navController = navHostController) }
    ) {
        AdminNavGraph(navController = navHostController)
    }

}