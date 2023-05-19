package com.savasapp.ecommerceappmvvm.presentation.screens.auth.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.register.components.RegisterState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel(){

    var state by mutableStateOf(RegisterState())
        private set

    fun onNameInput(name : String){
        state = state.copy(name  = name)
    }

    fun onLastNameInput(lastName : String){
        state = state.copy(lastName  = lastName)
    }

    fun onEmailInput(email : String){
        state = state.copy(email  = email)
    }

    fun onPhoneInput(phone : String){
        state = state.copy(phone  = phone)
    }

    fun onPasswordInput(password : String){
        state = state.copy(password  = password)
    }

    fun onConfirmPasswordInput(confimPassword : String){
        state = state.copy(confimPassword  = confimPassword)
    }
}

