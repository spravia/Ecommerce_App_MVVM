package com.savasapp.ecommerceappmvvm.presentation.screens.admin.prodcut.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.savasapp.ecommerceappmvvm.presentation.screens.admin.prodcut.list.components.AdminCategoryListContent


@Composable
fun AdminCategoryListScreen(){

    Scaffold() {paddingValues ->
        AdminCategoryListContent(paddingValues = paddingValues)
    }

}