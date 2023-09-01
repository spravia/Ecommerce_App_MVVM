package com.savasapp.ecommerceappmvvm.presentation.screens.admin.category.create.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.savasapp.ecommerceappmvvm.android.R
import com.savasapp.ecommerceappmvvm.presentation.components.DefaultTextField
import com.savasapp.ecommerceappmvvm.presentation.components.DialogCapturePicture
import com.savasapp.ecommerceappmvvm.presentation.screens.admin.category.create.AdminCategoryCreateViewModel

@Composable
fun AdminCategoryCreateConten(paddingValues: PaddingValues, vm : AdminCategoryCreateViewModel = hiltViewModel()){

    val state = vm.state
    vm.resultingActivityHandler.handle()
    val stateDialog = remember { mutableStateOf(false) }
    
    DialogCapturePicture(state = stateDialog,
                         takePhoto = { vm.takePhoto()},
                         pickImage = {vm.pickImage()})

    Column(modifier = Modifier
        .padding(paddingValues = paddingValues)
        .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally)
    {

        Spacer(modifier = Modifier.height(40.dp))

        Image(
            modifier = Modifier.size(150.dp).clickable {
                    stateDialog.value = true
            },
            painter = painterResource(id = R.drawable.image_add),
            contentDescription = ""
        )

        //TODO enviar abajo el contenido con weight
        Spacer(modifier = Modifier.height(40.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            shape = RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp),
            backgroundColor = Color.White.copy(alpha = 0.7f) )
        {
            Column(
                modifier = Modifier.padding(20.dp)
            )
            {
                Text(
                    modifier = Modifier.padding(bottom = 20.dp),
                    text = "Update",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Blue
                )

                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.name,
                    label = "Category Name",
                    icon = Icons.Default.List,
                    onValueChange = { vm.onNameInput(it) }
                )

                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.description,
                    label = "Descripción",
                    icon = Icons.Default.Info,
                    onValueChange = { vm.onDescriptionInput(it) }
                )

                ElevatedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp),
                    onClick = { vm.createCategory() }
                )
                {
                    Text(text = "Create category")
                }

            }
        }
    }
}