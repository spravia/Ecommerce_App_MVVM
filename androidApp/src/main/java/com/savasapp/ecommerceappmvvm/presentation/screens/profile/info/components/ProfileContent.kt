package com.savasapp.ecommerceappmvvm.presentation.screens.profile.info.components

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.savasapp.ecommerceappmvvm.android.R
import com.savasapp.ecommerceappmvvm.presentation.navigation.Graph
import com.savasapp.ecommerceappmvvm.presentation.screens.profile.info.ProfileViewModel
import com.savasapp.ecommerceappmvvm.presentation.ui.theme.MainActivity


@SuppressLint("SuspiciousIndentation")
@Composable
fun ProfileContent(paddingValues: PaddingValues,
                   navController: NavHostController,
                   vm: ProfileViewModel = hiltViewModel()
){

    val activity = LocalContext.current as? Activity

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
        .padding(bottom = 55.dp))
    {
        Image(
            modifier = Modifier.fillMaxSize(),
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
            IconButton(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 15.dp, top = 15.dp),
                onClick = {
                    vm.logOut()
                    activity?.finish()
                    activity?.startActivity(Intent(activity,MainActivity::class.java))
                })
            {
              Icon(
                  modifier= Modifier.size(35.dp) ,
                  imageVector = Icons.Default.ExitToApp,
                  contentDescription = "",
                  tint = Color.White)
            }
            Image(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.mipmap.fotosavas), contentDescription = ""
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
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                    )
                {
                    Icon(imageVector = Icons.Default.Person, contentDescription = "", tint = Color.Yellow)

                    Column(
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )
                    {
                        vm.user?.name?.let { Text(text = it) }.run { " " }

                        Text(
                            text = "User Name",
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    }
                }

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Icon(imageVector = Icons.Default.Email, contentDescription = "", tint = Color.Yellow)

                    Column(
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )
                    {
                        vm.user?.mail?.let { Text(text = it) }.run { " " }

                        Text(
                            text = "E-Mail",
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    }
                }

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Icon(imageVector = Icons.Default.Phone, contentDescription = "", tint = Color.Yellow)

                    Column(
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )
                    {
                        vm.user?.phone?.let { Text(text = it) }.run { " " }

                        Text(
                            text = "Phone Number",
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    }
                }

                ElevatedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp),
                    onClick = {
                        //TODO pasar parametro por NavController
                        navController.navigate(route =  "${Graph.PROFILE}/${vm.user?.toJson()}"){
                                // falta el PopUp
                        }

                    })
                {
                    Text(text = "Update personal information")
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

  //  ProfileContent(paddingValues = PaddingValues())
}