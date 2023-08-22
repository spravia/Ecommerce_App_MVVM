package com.savasapp.ecommerceappmvvm.presentation.screens.profile.update.components

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.savasapp.ecommerceappmvvm.domain.repository.Resource
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.components.CircleProgressBar
import com.savasapp.ecommerceappmvvm.presentation.screens.profile.update.ProfileUpdateViewModel

@Composable
fun UpdateUser( vm: ProfileUpdateViewModel = hiltViewModel()){

    when(val response = vm.updateResponse){

        Resource.Loading -> {
            CircleProgressBar()
        }
        is Resource.Success -> {
                Log.d("UpdateUser","${response.data}")
                vm.updateUserSession()
                Toast.makeText(LocalContext.current , "Information hab been updated" , Toast.LENGTH_LONG).show()
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