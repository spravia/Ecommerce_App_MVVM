package com.savasapp.ecommerceappmvvm.presentation.screens.admin.category.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.savasapp.ecommerceappmvvm.presentation.screens.admin.category.list.components.AdminProductListContent

@Composable
fun AdminProductListScreen(){

    Scaffold() {paddingValues ->
        AdminProductListContent(paddingValues = paddingValues)
    }

}

