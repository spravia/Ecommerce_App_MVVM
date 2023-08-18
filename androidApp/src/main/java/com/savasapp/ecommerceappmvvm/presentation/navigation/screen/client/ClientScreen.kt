package com.savasapp.ecommerceappmvvm.presentation.navigation.screen.client

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ClientScreen(
    val route : String,
    val title : String,
    val icon  : ImageVector
)
{
    object CategoryList : ClientScreen("client/category/list", title = "Categorisa", icon = Icons.Default.List)
    object ProductList : ClientScreen("client/product/list", title = "Productos", icon = Icons.Default.ThumbUp)
    object Profile : ClientScreen("client/profile", title = "Perfil", icon = Icons.Default.Person)

}

