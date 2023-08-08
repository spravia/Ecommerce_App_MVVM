package com.savasapp.ecommerceappmvvm.presentation.screens.profile.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.components.DefaultButton
import com.savasapp.ecommerceappmvvm.presentation.screens.profile.ProfileViewModel
import com.savasapp.ecommerceappmvvm.presentation.ui.theme.MainActivity

@Composable
fun ProfileContent(paddingValues: PaddingValues,
                   vm: ProfileViewModel = hiltViewModel()){

    val activity = LocalContext.current as? Activity

    DefaultButton(modifier = Modifier.padding(paddingValues=paddingValues),
                  text = "Cerrar sesión",
                  onClick = {
                               vm.logOut()
                               activity?.finish()

                        // TODO permite re iniciar y volver a la pantalla inicial del MainActivity y al metodo onCreate
                               activity?.startActivity(Intent(activity,MainActivity::class.java))

                             }
                  )


}