package com.savasapp.ecommerceappmvvm.presentation.screens.auth.register.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.savasapp.ecommerceappmvvm.android.R
import com.savasapp.ecommerceappmvvm.presentation.components.DefaultTextField
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.components.DefaultButton


@Composable
fun RegisterContet(paddingValues: PaddingValues){

    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
        .fillMaxSize())
    {
        Image(modifier = Modifier ,painter = painterResource(id = R.drawable.banner), contentDescription = "", contentScale = ContentScale.Crop,
                       colorFilter =  ColorFilter.colorMatrix(ColorMatrix().apply { setToScale(0.6f,0.6f,0.6f, 0.6f) }))

        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally)
        {
           Row(modifier = Modifier.fillMaxWidth().padding(top = 35.dp),
               verticalAlignment = Alignment.CenterVertically,
               horizontalArrangement = Arrangement.Center)
           {

            Image(modifier = Modifier
                .height(80.dp)
                .width(80.dp),
                painter = painterResource(id = R.drawable.user_form), contentDescription = "")

            Text( modifier = Modifier.padding(top = 7.dp, start = 10.dp), text = "Ingresa esta informaciòn", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White)

            }

            Spacer(modifier = Modifier.weight(1f))

            Card(modifier = Modifier.fillMaxWidth(),
                 shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                 backgroundColor = Color.White.copy(alpha = 0.8f))
            {
                Column(modifier = Modifier.padding(top = 30.dp, start = 30.dp, end = 30.dp, bottom = 15.dp )) {

                    Text(modifier = Modifier.padding(bottom = 10.dp),
                         text = "Registate",
                         fontWeight = FontWeight.Bold,
                         fontSize = 20.sp,
                         color = Color.Black)

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "" ,
                        label = "Nombres",
                        icon =  Icons.Default.Person,
                        onValueChange = { }
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "" ,
                        label = "Apellidos",
                        icon =  Icons.Outlined.Person,
                        onValueChange = { }
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "" ,
                        label = "Correo electronico",
                        icon =  Icons.Default.Email,
                        onValueChange = { },
                        keyboardType = KeyboardType.Email
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "" ,
                        label = "Telefono",
                        icon =  Icons.Default.Phone,
                        onValueChange = { },
                        keyboardType = KeyboardType.Number
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "" ,
                        label = "Contraseña",
                        icon =  Icons.Default.Lock,
                        onValueChange = { },
                        keyboardType = KeyboardType.Password
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "" ,
                        label = "Confirmar Contraseña",
                        icon =  Icons.Default.Lock,
                        onValueChange = { },
                        keyboardType = KeyboardType.Password
                    )
                    
                    Spacer(modifier = Modifier.height(5.dp))

                    DefaultButton(modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp), text = "Confirmar" , onClick = {  })
                }
            }
        }
    }


}

@Preview
@Composable
fun PreviewRegisterContent(){

    Scaffold() { paddingValues ->
            RegisterContet(paddingValues = paddingValues)
    }

}