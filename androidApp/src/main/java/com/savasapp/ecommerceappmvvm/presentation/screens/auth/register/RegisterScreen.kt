package com.savasapp.ecommerceappmvvm.presentation.screens.auth.register

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.savasapp.ecommerceappmvvm.android.MyApplicationTheme
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.components.DefaultTopAppBar
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.register.components.RegisterContet


@Composable
fun RegisterScreen(
    navController: NavHostController
){
    Scaffold(
      topBar = {
         DefaultTopAppBar(title = "Register", navController = navController, upAvailable = true)
      }
    ) { paddingValues ->
        RegisterContet(paddingValues = paddingValues)
    }
}

@Preview
@Composable
fun PreviewRegisterScreen(){
    MyApplicationTheme() {
        var navController = rememberNavController()
        RegisterScreen(navController)
    }

}