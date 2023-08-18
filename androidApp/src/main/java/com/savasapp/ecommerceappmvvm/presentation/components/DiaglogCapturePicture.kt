package com.savasapp.ecommerceappmvvm.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.AlertDialog
import androidx.compose.material3.Button

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DialogCapturePicture(
    state : MutableState<Boolean>,
    takePhoto: () -> Unit,
    pickImage: () -> Unit
){

    if(state.value == true)
    {          // TODO Crear un AlertDialog
    AlertDialog(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        backgroundColor = Color.White,
        onDismissRequest = {{state.value = false}  },
        title = {
                Text(text = "Select an option", fontSize = 20.sp,color = Color.Blue)
        },
        buttons = {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
            )
            {
                Button(
                    onClick = {
                        state.value = false
                        pickImage()
                              },
                    modifier = Modifier.width(130.dp)
                ) {
                    Text(text = "Galery")
                }


                Button(
                    onClick = {
                        state.value = false
                        takePhoto()
                    },
                    modifier = Modifier.width(130.dp)
                ) {
                    Text(text = "Camera")
                }
            }
        }
    )
    }
}

