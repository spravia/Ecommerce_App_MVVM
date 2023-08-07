package com.savasapp.ecommerceappmvvm.presentation.screens.auth.register

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.savasapp.ecommerceappmvvm.android.MyApplicationTheme
import com.savasapp.ecommerceappmvvm.presentation.components.DefaultTopAppBar
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.register.components.Register
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


    Register(navController = navController)
}

@Preview
@Composable
fun PreviewRegisterScreen(){
    MyApplicationTheme() {
        var navController = rememberNavController()
        RegisterScreen(navController)
    }

}