package com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor()  : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    //var email by  mutableStateOf("")
    //var password by  mutableStateOf("")


    fun onEmailInput(email : String){
        state = state.copy(email= email)
    }

    fun onPasswordInput(password : String){
        state = state.copy(password = password)
    }

}