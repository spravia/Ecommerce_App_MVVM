package com.savasapp.ecommerceappmvvm.presentation.screens.profile.components

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.widget.Space
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.components.DefaultButton
import com.savasapp.ecommerceappmvvm.presentation.screens.profile.ProfileViewModel
import com.savasapp.ecommerceappmvvm.presentation.ui.theme.MainActivity

@SuppressLint("SuspiciousIndentation")
@Composable
fun ProfileContent(paddingValues: PaddingValues,
                   vm: ProfileViewModel = hiltViewModel()){

    val activity = LocalContext.current as? Activity

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