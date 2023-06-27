package com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.savasapp.ecommerceappmvvm.domain.repository.Resource
import com.savasapp.ecommerceappmvvm.presentation.navigation.screen.AuthScreen
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.LoginViewModel

@Composable
fun Login( navController: NavHostController,vm: LoginViewModel = hiltViewModel()){

    when(val response = vm.loginResponse){

        Resource.Loading -> {
            CircleProgressBar()
        }
        is Resource.Success -> {
            LaunchedEffect(Unit){
                navController.navigate(route = AuthScreen.Home.route)
            }

        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT).show()
        }
        else -> {
            Log.d("","")
            if (response != null)
            {
               Toast.makeText(LocalContext.current, "There is a unknow error", Toast.LENGTH_SHORT).show()
            }

        }
    }
}