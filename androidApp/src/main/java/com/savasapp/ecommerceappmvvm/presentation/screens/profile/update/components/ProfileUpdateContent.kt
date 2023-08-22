package com.savasapp.ecommerceappmvvm.presentation.screens.profile.update.components

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.savasapp.ecommerceappmvvm.android.R
import com.savasapp.ecommerceappmvvm.presentation.components.DefaultTextField
import com.savasapp.ecommerceappmvvm.presentation.components.DialogCapturePicture
import com.savasapp.ecommerceappmvvm.presentation.screens.profile.info.ProfileViewModel
import com.savasapp.ecommerceappmvvm.presentation.screens.profile.update.ProfileUpdateViewModel
import com.savasapp.ecommerceappmvvm.presentation.ui.theme.MainActivity

@SuppressLint("SuspiciousIndentation")
@Composable
fun ProfileUpdateContent(paddingValues: PaddingValues,
                   vm: ProfileUpdateViewModel = hiltViewModel()
){

    val activity = LocalContext.current as? Activity
    val state = vm.state
    val stateDialog = remember { mutableStateOf(false) }

       //Inicializar variable resultingActivityHandler
    vm.resultingActivityHandler.handle()

    DialogCapturePicture(state = stateDialog , takePhoto = { vm.takePhoto() }, pickImage = { vm.pickImage() } )

    /*
        ElevatedButton(

            modifier = Modifier.padding(paddingValues=paddingValues),
            elevation = ButtonDefaults.buttonElevation(8.dp),
            onClick = {   vm.logOut()
                          activity?.finish()
                          activity?.startActivity(Intent(activity,MainActivity::class.java))
                       }
        )
        {
             Icon(imageVector = Icons.Default.Close, contentDescription = "", modifier = Modifier.size(18.dp))
            Spacer(modifier = Modifier.width(8.dp))
             Text(text = "Logout")
        }
*/

    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
        )
    {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.profile_background), contentDescription = "",
            contentScale = ContentScale.Crop,
            //TODO permite hacer la imagen mas oscura
            colorFilter = ColorFilter.colorMatrix
            (
              ColorMatrix().apply { setToScale(0.6f, 0.6f, .6f, 1f)}
            )
        )

        Column(modifier = Modifier.fillMaxWidth())
        {

            Image(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 40.dp)
                    .clickable { stateDialog.value = true },

                painter = painterResource(id = R.drawable.user_image), contentDescription = ""
            )

            Spacer(modifier = Modifier.weight(1f))

            androidx.compose.material.Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp),
                backgroundColor = Color.White.copy(alpha = 0.7f)
            )
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
                    label = "Name",
                    icon = Icons.Default.Person,
                    onValueChange = { vm.onNameInput(it)}
                )

                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.lastName,
                    label = "Apellidos",
                    icon = Icons.Default.Person,
                    onValueChange = { vm.onLastNameInput(it)}
                )

                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.phone,
                    label = "Phone Number",
                    icon = Icons.Default.Phone,
                    onValueChange = { vm.onPhoneInput(it)}
                )

                ElevatedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp),
                    onClick = {  vm.update() }
                )
                {
                    Text(text = "Update information")
                }

            }
        }
    }
}



/*
    DefaultButton(modifier = Modifier.padding(paddingValues=paddingValues),
                  text = "Cerrar sesión",
                  onClick = {
                               vm.logOut()
                               activity?.finish()

                        // TODO permite re iniciar y volver a la pantalla inicial del MainActivity y al metodo onCreate
                               activity?.startActivity(Intent(activity,MainActivity::class.java))

                             }
                  )
       */


}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileContentPreview(){

    ProfileUpdateContent(paddingValues = PaddingValues())
}