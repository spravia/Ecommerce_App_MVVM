package com.savasapp.ecommerceappmvvm.presentation.components

import android.icu.text.CaseMap.Title
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.material.TopAppBar
import androidx.navigation.NavHostController

@Composable
fun DefaultTopAppBar(
    title: String,
    upAvailable : Boolean = false,
    navController:NavHostController?
) {
    TopAppBar(title = { Text(text = title, fontSize = 19.sp)},
        backgroundColor = Color.White,
        navigationIcon = {
            if (upAvailable) {
            IconButton(onClick = {  navController?.popBackStack() }) {
                Icon(imageVector = Icons.Default.ArrowBack , contentDescription = "" , tint = Color.Black)
                }
            }
        }
    )
}


