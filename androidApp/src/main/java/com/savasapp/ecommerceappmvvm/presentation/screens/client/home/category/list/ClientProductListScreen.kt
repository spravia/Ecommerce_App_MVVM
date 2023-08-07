package com.savasapp.ecommerceappmvvm.presentation.screens.client.home.category.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.savasapp.ecommerceappmvvm.presentation.screens.client.home.category.list.components.ClientProductListContent

@Composable
fun ClientProductListScreen(){

    Scaffold() {paddingValues ->
        ClientProductListContent(paddingValues = paddingValues)
    }

}

