package com.savasapp.ecommerceappmvvm.presentation.screens.profile.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ProfileContent(paddingValues: PaddingValues){
    
    Text(text = "Profile Screen", modifier = Modifier.padding(paddingValues = paddingValues))


}