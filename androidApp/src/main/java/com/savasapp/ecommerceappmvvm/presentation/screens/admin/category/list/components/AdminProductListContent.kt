package com.savasapp.ecommerceappmvvm.presentation.screens.admin.category.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AdminProductListContent(paddingValues: PaddingValues){
    
    Text(text = "Admin Product Screen", modifier = Modifier.padding(paddingValues = paddingValues))


}