package com.savasapp.ecommerceappmvvm.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun DefaultTextField(
    modifier: Modifier,
    value: String,
    label : String,
    icon : ImageVector,
    keyboardType: KeyboardType = KeyboardType.Text,   //Tipo de teclado para el TextBox
    onValueChange : (String) -> Unit,
){

    OutlinedTextField(modifier = modifier.fillMaxWidth(), value = value,
        onValueChange = {
                        onValueChange(it)
        },
        label = { Text(text = label) },
        leadingIcon = {
            Icon(imageVector = icon,
                contentDescription = "",
                tint = Color.Cyan)
        },
        keyboardOptions =  KeyboardOptions(keyboardType = keyboardType)
    )
}