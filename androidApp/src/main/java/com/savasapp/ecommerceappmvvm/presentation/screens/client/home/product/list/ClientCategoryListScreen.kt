package com.savasapp.ecommerceappmvvm.presentation.screens.client.home.product.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.savasapp.ecommerceappmvvm.presentation.screens.client.home.product.list.components.ClientCategoryListContent

@Composable
fun ClienteCategoryListScreen(){

    Scaffold() {paddingValues ->
        ClientCategoryListContent(paddingValues = paddingValues)
    }

}