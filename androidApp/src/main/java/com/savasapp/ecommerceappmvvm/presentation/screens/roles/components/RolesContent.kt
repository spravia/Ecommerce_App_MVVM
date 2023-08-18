package com.savasapp.ecommerceappmvvm.presentation.screens.roles.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.savasapp.ecommerceappmvvm.presentation.navigation.Graph

@Composable
fun RolesContent(paddingValues: PaddingValues, navController: NavHostController,
                 vm: RolesViewModel = hiltViewModel()){

    val data = vm.authReponse

    val list = arrayListOf<String>("admin_graph", "client_graph")

    LazyColumn(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

         items(
             items = list ?: arrayListOf()
         ) {
             Column(modifier = Modifier.clickable {

               //TODO uso de popUp
                navController.navigate(route = it ){
                  //  popUpTo(route = Graph.ROLES) {inclusive = true}
                }
             })
             {
                Spacer(modifier = Modifier.height(25.dp))
                AsyncImage(
                     modifier = Modifier
                         .height(150.dp)
                         .width(150.dp),
                     model = "https://firebasestorage.googleapis.com/v0/b/test-project-5aee4.appspot.com/o/foto.png?alt=media&token=7cece0d4-967d-4dda-b239-ab428916a194",
                     contentDescription = null
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                     text = it.uppercase().trim(),
                     fontWeight = FontWeight.Bold,
                     fontSize = 17.sp
                )
             }
         }
    }
}