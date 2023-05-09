package com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.savasapp.ecommerceappmvvm.android.Blue500
import com.savasapp.ecommerceappmvvm.android.R
import com.savasapp.ecommerceappmvvm.presentation.components.DefaultTextField
import com.savasapp.ecommerceappmvvm.presentation.navigation.screen.AuthScreen

@Composable
fun LoginContent(navController: NavHostController,
                 paddingValues: PaddingValues ,
                 vm : LoginViewModel = hiltViewModel()){

    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
        .fillMaxSize()){
        Image(painter =  painterResource(id = R.drawable.banner) ,
            contentDescription = null  ,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToScale(0.5f,0.5f,0.5f,0.5f) })
        )
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 150.dp)
            .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp),
                painter = painterResource(id = R.drawable.shopping_cart_blue),
                contentDescription = null )
            Text( modifier = Modifier.padding(top = 7.dp),
                text = "ECOMMER APP",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                shape = RoundedCornerShape(    //bordes en la parte superior
                    topEnd = 40.dp, topStart = 40.dp),
                backgroundColor = Color.White.copy(alpha = 0.5f),

                ) {
                Column (modifier = Modifier.padding(10.dp)) {
                    Text(modifier = Modifier.padding(bottom = 20.dp),
                        text = "Sing in",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black)
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = vm.email,
                        label = "Correo Electronico",
                        icon = Icons.Default.Email,
                        onValueChange = { vm.email = it },
                        keyboardType = KeyboardType.Email
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = vm.password,
                        label = "Password",
                        icon = Icons.Default.Email,
                        onValueChange = { vm.password = it },
                        keyboardType = KeyboardType.Password
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    DefaultButton(modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                                  text = "Login",
                                  onClick = {  }
                    )
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 17.dp),
                        horizontalArrangement = Arrangement.Center) {
                        Text(text = "Don't have an account?")
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(text = "Sing up", color  = Blue500, fontWeight = FontWeight.Bold,
                             modifier = Modifier.clickable { navController.navigate(route = AuthScreen.Register.route) })
                    }
                }
            }
        }
    }
}