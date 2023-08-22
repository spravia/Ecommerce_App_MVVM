package com.savasapp.ecommerceappmvvm.presentation.screens.auth.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.savasapp.ecommerceappmvvm.domain.model.AuthResponse
import com.savasapp.ecommerceappmvvm.domain.model.RegisterResponse
import com.savasapp.ecommerceappmvvm.domain.model.Rol
import com.savasapp.ecommerceappmvvm.domain.model.User
import com.savasapp.ecommerceappmvvm.domain.repository.Resource
import com.savasapp.ecommerceappmvvm.domain.useCase.auth.AuthUseCase
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.register.components.RegisterState
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.register.components.mapper.toUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val authUseCase: AuthUseCase) : ViewModel()
{

    var state by mutableStateOf(RegisterState())
    var errorMessage by mutableStateOf("")

    var registerResponse by mutableStateOf<Resource<RegisterResponse>?>(null)

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }

    fun register() = viewModelScope.launch {

        if(isValidForm()) {

            registerResponse = Resource.Loading     //TODO aplicando MAPPER de RegisterStateMapper
            val result = authUseCase.register(state.toUser())
            registerResponse = result
        }
    }

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

    fun isValidForm() : Boolean{

        if(state.name == ""){
            errorMessage = "Ingrese el nombre"
            return false
        }else if(state.lastName == ""){
            errorMessage = "Ingrese el apellido"
            return false
        }else if(state.email == ""){
            errorMessage = "Ingrese el correo electronico"
            return false
        }else  if(state.password == ""){
            errorMessage = "Ingrese el password"
            return false
        }else if (state.password != state.confimPassword){
            errorMessage = "Password no son iguales"
            return false
        }

        return  true
    }
}

