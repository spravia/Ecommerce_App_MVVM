package com.savasapp.ecommerceappmvvm.presentation.screens.profile.update

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.savasapp.ecommerceappmvvm.presentation.components.DefaultTopAppBar
import com.savasapp.ecommerceappmvvm.presentation.screens.profile.update.components.ProfileUpdateContent
import com.savasapp.ecommerceappmvvm.presentation.screens.profile.update.components.UpdateUser


//TODO pasar parametro por NavController
@Composable
fun ProfileUpdateScreen(navController: NavHostController, userParam : String){

    Log.d("Savas","Data : $userParam")

    Scaffold(
        topBar = { DefaultTopAppBar(title = "Update user", navController =navController, upAvailable = true )}

    ) {paddingValues ->
        ProfileUpdateContent(paddingValues = paddingValues)


    }
      //Pantalla de datos actualizados
    UpdateUser()

}