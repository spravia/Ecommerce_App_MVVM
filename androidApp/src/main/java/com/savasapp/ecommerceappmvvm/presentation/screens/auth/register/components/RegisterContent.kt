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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.savasapp.ecommerceappmvvm.android.R
import com.savasapp.ecommerceappmvvm.presentation.components.DefaultTextField
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.components.DefaultButton
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.register.RegisterViewModel


@Composable
fun RegisterContet(paddingValues: PaddingValues, vm: RegisterViewModel = hiltViewModel()) {

    val state = vm.state

    Box(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxSize()
    )
    {
        Image(modifier = Modifier,
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
                setToScale(
                    0.6f,
                    0.6f,
                    0.6f,
                    0.6f
                )
            })
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 35.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            )
            {

                Image(
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp),
                    painter = painterResource(id = R.drawable.user_form), contentDescription = ""
                )

                Text(
                    modifier = Modifier.padding(top = 7.dp, start = 10.dp),
                    text = "Ingresa esta informaciòn",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.White
                )

            }

            Spacer(modifier = Modifier.weight(1f))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                backgroundColor = Color.White.copy(alpha = 0.8f)
            )
            {
                Column(
                    modifier = Modifier
                        .padding(
                            top = 30.dp,
                            start = 30.dp,
                            end = 30.dp,
                            bottom = 15.dp
                        )
                        .verticalScroll(rememberScrollState())
                )
                {

                    Text(
                        modifier = Modifier.padding(bottom = 10.dp),
                        text = "Registate",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.name,
                        label = "Nombres",
                        icon = Icons.Default.Person,
                        onValueChange = { vm.onNameInput(it) }
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.lastName,
                        label = "Apellidos",
                        icon = Icons.Outlined.Person,
                        onValueChange = { vm.onLastNameInput(it) }
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.email,
                        label = "Correo electronico",
                        icon = Icons.Default.Email,
                        onValueChange = { vm.onEmailInput(it) },
                        keyboardType = KeyboardType.Email
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.phone,
                        label = "Telefono",
                        icon = Icons.Default.Phone,
                        onValueChange = { vm.onPhoneInput(it) },
                        keyboardType = KeyboardType.Number
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.password,
                        label = "Contraseña",
                        icon = Icons.Default.Lock,
                        onValueChange = { vm.onPasswordInput(it) },
                        keyboardType = KeyboardType.Password,
                        hideText = true
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.confimPassword,
                        label = "Confirmar Contraseña",
                        icon = Icons.Default.Lock,
                        onValueChange = { vm.onConfirmPasswordInput(it) },
                        keyboardType = KeyboardType.Password,
                        hideText = true
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    DefaultButton(modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp), text = "Confirmar", onClick = { })
                }
            }
        }
    }


}

@Preview
@Composable
fun PreviewRegisterContent() {

    Scaffold() { paddingValues ->
        RegisterContet(paddingValues = paddingValues)
    }

}