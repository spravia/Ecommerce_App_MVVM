package com.savasapp.ecommerceappmvvm.presentation.screens.admin.category.list.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.savasapp.ecommerceappmvvm.domain.repository.Resource
import com.savasapp.ecommerceappmvvm.presentation.screens.admin.category.list.AdminCategoryListViewModel
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.components.CircleProgressBar

@Composable
fun GetCategories( paddingValues: PaddingValues, vm : AdminCategoryListViewModel = hiltViewModel()){

    when(val response = vm.categoriesResponse){

        Resource.Loading -> {
            CircleProgressBar()
        }
        is Resource.Success -> {
            AdminProductListContent(categories = response.data, paddingValues)
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