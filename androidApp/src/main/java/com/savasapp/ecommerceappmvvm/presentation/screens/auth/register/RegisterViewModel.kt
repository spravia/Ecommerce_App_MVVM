package com.savasapp.ecommerceappmvvm.presentation.screens.auth.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.savasapp.ecommerceappmvvm.domain.model.AuthResponse
import com.savasapp.ecommerceappmvvm.domain.model.User
import com.savasapp.ecommerceappmvvm.domain.repository.Resource
import com.savasapp.ecommerceappmvvm.domain.useCase.auth.AuthUseCase
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.register.components.RegisterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val authUseCase: AuthUseCase) : ViewModel()
{

    var state by mutableStateOf(RegisterState())
    var errorMessage by mutableStateOf("")

    var registerResponse by mutableStateOf<Resource<AuthResponse>?>(null)

    fun register() = viewModelScope.launch {

        if(isValidForm()) {
            val user = User(
                id = 0,
                name = state.name,
                lastname =  state.lastName,
                phone = state.phone,
                email = state.email,
                password = state.password
            )

            registerResponse = Resource.Loading
            val result = authUseCase.register(user)
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
        }

        return  true
    }
}

