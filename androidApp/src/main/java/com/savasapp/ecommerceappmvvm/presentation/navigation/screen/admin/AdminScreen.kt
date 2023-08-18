package com.savasapp.ecommerceappmvvm.presentation.navigation.screen.admin

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AdminScreen(
    val route : String,
    val title : String,
    val icon  : ImageVector
)
{
    object CategoryList : AdminScreen("admin/category/list", title = "Categorias", icon = Icons.Default.List)
    object ProductList : AdminScreen("admin/product/list", title = "Productos", icon = Icons.Default.ThumbUp)
    object Profile : AdminScreen("admin/profile", title = "Perfil", icon = Icons.Default.Person)

}
