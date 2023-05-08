package com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.savasapp.ecommerceappmvvm.android.Blue500

@Composable
fun DefaultButton(
    modifier: Modifier,
    text: String,
    onClick : () -> Unit,
    color : Color = Blue500,
    icon : ImageVector = Icons.Default.ArrowForward
){
    Button( modifier = modifier,
        onClick = {  onClick() },
        colors = ButtonDefaults.buttonColors(backgroundColor = color))
    {
        Icon(imageVector = icon, contentDescription = "", tint = Color.White )
        Text(text = text, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDefaultButton(){

    DefaultButton(modifier = Modifier.fillMaxWidth().height(50.dp),
        text = "Login",
        onClick = {  }
    )

}
