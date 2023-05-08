package com.savasapp.ecommerceappmvvm.android

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


//https://www.materialpalette.com/brown/cyan


val Purple200 = Color(0xFFBB86FC)
val Blue200   = Color(0xFFB3E5FC)
val Blue500   = Color(0xFF03A9F4)
val Blue700   = Color(0xFF0288D1)
val Teal500   = Color(0xFF009688)
val Purple700 = Color(0xFF3700B3)
val Teal200   = Color(0xFF03DAC5)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColors(
            primary = Purple200,
            primaryVariant = Purple700,
            secondary = Teal200
        )
    } else {
        lightColors(
            primary = Blue500,
            primaryVariant = Blue700,
            secondary = Teal500
        )
    }
    val typography = Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
