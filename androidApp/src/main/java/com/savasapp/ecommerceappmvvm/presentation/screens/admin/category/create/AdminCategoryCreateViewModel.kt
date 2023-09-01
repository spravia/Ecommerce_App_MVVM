package com.savasapp.ecommerceappmvvm.presentation.screens.admin.category.create

import android.content.Context
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.optic.ecommerceappmvvm.presentation.util.ResultingActivityHandler

import com.savasapp.ecommerceappmvvm.domain.model.Category
import com.savasapp.ecommerceappmvvm.domain.repository.Resource

import com.savasapp.ecommerceappmvvm.domain.useCase.categories.CreateCategoryUseCase
import com.savasapp.ecommerceappmvvm.presentation.screens.admin.category.create.mapper.toCategory
import com.savasapp.ecommerceappmvvm.presentation.util.ComposeFileProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AdminCategoryCreateViewModel @Inject constructor(private val categoryUseCase: CreateCategoryUseCase,
                                                       @ApplicationContext private val  context: Context) : ViewModel()
{

    var state by mutableStateOf(AdminCategoryCreateState())
        private set


    var categoryResponse by mutableStateOf<Resource<Category>?>(null)

    var file : File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    fun createCategory() = viewModelScope.launch{

        categoryResponse = Resource.Loading

        val result = categoryUseCase.invoke(state.toCategory())

        categoryResponse = result
    }

    fun clearForm(){
        state = state.copy("","","")

        categoryResponse = null
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

    fun onNameInput(input : String){
        state = state.copy(name = input)
    }

    fun onDescriptionInput(input: String){
        state = state.copy(description = input)
    }

}