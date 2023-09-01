package com.savasapp.ecommerceappmvvm.presentation.screens.admin.category.create

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.savasapp.ecommerceappmvvm.presentation.components.DefaultTopAppBar
import com.savasapp.ecommerceappmvvm.presentation.screens.admin.category.create.components.AdminCategoryCreateConten
import com.savasapp.ecommerceappmvvm.presentation.screens.admin.category.create.components.CreateCategory


@Composable
fun AdminCategoryCreateSceen(navController: NavHostController) {

    Scaffold(topBar ={
                    DefaultTopAppBar(title = "New Category",
                                     navController = navController,
                                     upAvailable = true)
                     },
                contentColor = Color.Gray

    )
    { paddingValues ->
        AdminCategoryCreateConten(paddingValues = paddingValues)


    }

    CreateCategory()
}