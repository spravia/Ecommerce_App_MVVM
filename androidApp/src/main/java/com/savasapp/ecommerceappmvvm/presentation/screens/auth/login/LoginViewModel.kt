package com.savasapp.ecommerceappmvvm.presentation.screens.auth.login

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
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase)  : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set


    //var email by  mutableStateOf("")
    //var password by  mutableStateOf("")

    var errorMessage by mutableStateOf("")

    var loginResponse by mutableStateOf<Resource<AuthResponse>?>(null)
            private set

    fun login() = viewModelScope.launch {

        if(isValidateForm()){
            loginResponse = Resource.Loading   //waiting
            val loginData = LoginState(state.email, state.password)
            val result = authUseCase.login(loginData )   //return a response
            loginResponse = result   //sucessed or failed
            Log.d( "LoginViewModel",  "Response $loginResponse")
        }
    }

    fun onEmailInput(email : String){
        state = state.copy(email= email)
    }

    fun onPasswordInput(password : String){
        state = state.copy(password = password)
    }

    private fun isValidateForm() : Boolean {

        if(state.password.length < 1){
            errorMessage = "Password invalido"
            return false
        }

        /*
        if(!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "Email invalido"
            return false
        }
        else if(state.password.length < 1){
            errorMessage = "Password invalido"
            return false
        }*/

        return true
    }
}