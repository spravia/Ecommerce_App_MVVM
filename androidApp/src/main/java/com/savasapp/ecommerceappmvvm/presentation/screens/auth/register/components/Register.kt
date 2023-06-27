package com.savasapp.ecommerceappmvvm.presentation.screens.auth.register.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.savasapp.ecommerceappmvvm.domain.repository.Resource
import com.savasapp.ecommerceappmvvm.presentation.navigation.screen.AuthScreen
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.components.CircleProgressBar
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.register.RegisterViewModel
import retrofit2.Response

@Composable
fun Register(navController: NavHostController, vm : RegisterViewModel = hiltViewModel())
{
    when(val response = vm.registerResponse){
        Resource.Loading -> {  CircleProgressBar()  }

        is Resource.Success -> { navController.navigate(AuthScreen.Home.route) }

        is Resource.Failure -> { Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT).show()   }

        else -> { if (response != null) {  Toast.makeText(LocalContext.current, "Error desconocido", Toast.LENGTH_SHORT).show() }

        }
    }
}