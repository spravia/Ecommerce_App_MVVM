package com.savasapp.ecommerceappmvvm.presentation.screens.admin.category.create.mapper

import com.savasapp.ecommerceappmvvm.domain.model.Category
import com.savasapp.ecommerceappmvvm.presentation.screens.admin.category.create.AdminCategoryCreateState

fun AdminCategoryCreateState.toCategory() : Category {

      return Category(
          name = name,
          descripcion = description,
          image = image
      )
}