package com.savasapp.ecommerceappmvvm.presentation.screens.auth.register.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.savasapp.ecommerceappmvvm.domain.repository.Resource
import com.savasapp.ecommerceappmvvm.presentation.navigation.Graph
import com.savasapp.ecommerceappmvvm.presentation.navigation.screen.auth.AuthScreen
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.components.CircleProgressBar
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.register.RegisterViewModel

@Composable
fun Register(navController: NavHostController, vm : RegisterViewModel = hiltViewModel())
{
    when(val response = vm.registerResponse){

        Resource.Loading -> {  CircleProgressBar()  }

        is Resource.Success -> {
        LaunchedEffect(Unit){
            //vm.saveSession(response.data)
            navController.navigate(Graph.CLIENT) {
                popUpTo(AuthScreen.Login.route) {inclusive = true}

            }
           }
        }

        is Resource.Failure -> { Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT).show()   }

        else -> { if (response != null) {  Toast.makeText(LocalContext.current, "Error desconocido", Toast.LENGTH_SHORT).show() }

        }
    }
}