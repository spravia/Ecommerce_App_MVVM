package com.savasapp.ecommerceappmvvm.presentation.screens.roles.components

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.savasapp.ecommerceappmvvm.domain.model.AuthResponse
import com.savasapp.ecommerceappmvvm.domain.repository.Resource
import com.savasapp.ecommerceappmvvm.domain.useCase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RolesViewModel @Inject constructor(private  val authUseCase: AuthUseCase) : ViewModel() {


    var authReponse by mutableStateOf(AuthResponse())

    init {
        getSessionData()
    }

    private fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect(){ data ->

            if (data.name != null)
            {
                authReponse = data
                Log.d("LoginViewModel","Data: ${data.toJson()}")
            }
            else{
                Log.d("LoginViewModel","Data: NULL")
            }
        }
    }
}