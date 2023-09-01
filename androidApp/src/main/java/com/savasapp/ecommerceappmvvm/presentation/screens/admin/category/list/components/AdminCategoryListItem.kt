package com.savasapp.ecommerceappmvvm.presentation.screens.admin.category.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.savasapp.ecommerceappmvvm.android.R
import com.savasapp.ecommerceappmvvm.domain.model.Category

@Composable
fun AdminCategoryListItem(category: Category){

 Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 15.dp)
                           .height(90.dp))
 {

    Row() {

        AsyncImage(
            modifier = Modifier
                .size(70.dp)
                .clip(RoundedCornerShape(10.dp)),
            model = category.image, contentDescription = "")

        Spacer(modifier = Modifier.width(10.dp))

        Column(modifier = Modifier.weight(1f))
        {
         Text(text =category.name, color = Color.Black, fontSize = 17.sp)

         Spacer(modifier = Modifier.height(5.dp))

         Text(text =category.descripcion, color = Color.Black, fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.width(15.dp))

        Column(verticalArrangement = Arrangement.Center)
        {
            Image(modifier = Modifier.size(25.dp),
                 painter = painterResource(id = R.drawable.edit),
                 contentDescription ="")

            Spacer(modifier = Modifier.height(5.dp))

            Image(modifier = Modifier.size(25.dp),
                 painter = painterResource(id = R.drawable.trash),
                 contentDescription ="")
            
        }
    }

     Spacer(modifier = Modifier.height(10.dp))
     Divider(color = Color.White,
         startIndent = 30.dp)
 }
}


@Preview
@Composable
fun PreviewAdminCategoryListItem(){


    val cat = Category(name = "Savas", descripcion = "test", image = "")

    AdminCategoryListItem(category = cat)


}

