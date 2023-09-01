package com.savasapp.ecommerceappmvvm.presentation.screens.admin.category.list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.savasapp.ecommerceappmvvm.presentation.components.DefaultTopAppBar
import com.savasapp.ecommerceappmvvm.presentation.navigation.Graph
import com.savasapp.ecommerceappmvvm.presentation.screens.admin.category.list.components.AdminProductListContent
import com.savasapp.ecommerceappmvvm.presentation.screens.admin.category.list.components.GetCategories


@Composable
fun AdminProductListScreen(navController: NavHostController){

    Scaffold(

        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 60.dp),
                onClick = { navController.navigate(route = Graph.ADMIN_CATEGORY) },
                backgroundColor = Color.White)
            {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")
            }
        }
    )
    {  paddingValues ->   GetCategories(paddingValues)
    }
}

