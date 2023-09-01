package com.savasapp.ecommerceappmvvm.presentation.screens.admin.category.create.components

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.savasapp.ecommerceappmvvm.domain.repository.Resource
import com.savasapp.ecommerceappmvvm.presentation.screens.admin.category.create.AdminCategoryCreateViewModel
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.components.CircleProgressBar
import com.savasapp.ecommerceappmvvm.presentation.screens.profile.update.ProfileUpdateViewModel

@Composable
fun CreateCategory( vm: AdminCategoryCreateViewModel = hiltViewModel()){

    when(val response = vm.categoryResponse){

                Resource.Loading -> {
                    CircleProgressBar()
                }
                is Resource.Success -> {
                    Log.d("UpdateUser","${response.data}")
                    vm.clearForm()
                    Toast.makeText(LocalContext.current , "Information has been saved" , Toast.LENGTH_LONG).show()
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