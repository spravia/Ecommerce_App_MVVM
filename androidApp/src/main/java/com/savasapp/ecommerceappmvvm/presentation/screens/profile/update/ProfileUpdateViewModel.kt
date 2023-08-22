package com.savasapp.ecommerceappmvvm.presentation.screens.profile.update

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.optic.ecommerceappmvvm.presentation.util.ResultingActivityHandler
import com.savasapp.ecommerceappmvvm.domain.model.User
import com.savasapp.ecommerceappmvvm.domain.repository.Resource
import com.savasapp.ecommerceappmvvm.domain.useCase.auth.AuthUseCase
import com.savasapp.ecommerceappmvvm.domain.useCase.users.UpdateUserUseCase
import com.savasapp.ecommerceappmvvm.domain.useCase.users.UsersUseCase
import com.savasapp.ecommerceappmvvm.presentation.screens.profile.update.components.ProfileUpdateState
import com.savasapp.ecommerceappmvvm.presentation.screens.profile.update.mapper.toUser
import com.savasapp.ecommerceappmvvm.presentation.util.ComposeFileProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext

import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val userUseCase: UsersUseCase,
    private val savedStateHandel : SavedStateHandle,
    @ApplicationContext private val  context: Context

) : ViewModel() {



        // TODO un data class dentro de un mutablestateof
    var state by mutableStateOf(ProfileUpdateState())
        private set

    val data = savedStateHandel.get<String>("user")
    var user = User.fromJson(data!!)


    var file : File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    // TODO manejo de null
    var updateResponse by mutableStateOf<Resource<User>?>(null)
        private set


    fun updateUserSession() = viewModelScope.launch {
        authUseCase.updateSession(state.toUser(user.id))
    }

    fun update() = viewModelScope.launch {

                                         //TODO haciendo MAPPER
        updateResponse = Resource.Loading                    //TODO forma de implementar UpdateStateMapper
        val result = userUseCase.updateUser(state.toUser(user.id))

        updateResponse = result

    }

    init {

        // TODO usando COPY para inicializar las propiedades de un state
        state = state.copy(
            name = user.nombres,
            lastName = user.apellidos,
            phone = user.telefono)
    }

    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/")
        if(result!=null){
            file = ComposeFileProvider.createFileFromUri(context, result )
            //state = state.copy( image = result.to())
        }

    }


    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null){
            var image = ComposeFileProvider.getPathFromBitmap(context, result)
            file= File(image)
        }

    }

    fun onNameInput(name : String){
        state = state.copy(name  = name)
    }

    fun onLastNameInput(lastName : String){
        state = state.copy(lastName  = lastName)
    }

    fun onPhoneInput(phone : String){
        state = state.copy(phone  = phone)
    }

}


