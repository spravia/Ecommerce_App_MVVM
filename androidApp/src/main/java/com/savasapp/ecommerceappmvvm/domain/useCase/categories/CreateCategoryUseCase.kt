package com.savasapp.ecommerceappmvvm.domain.useCase.categories

import com.savasapp.ecommerceappmvvm.domain.model.Category
import com.savasapp.ecommerceappmvvm.domain.repository.CategoryRepository
import com.savasapp.ecommerceappmvvm.presentation.screens.admin.category.create.AdminCategoryCreateState

class CreateCategoryUseCase (private val repository: CategoryRepository) {

    suspend fun invoke(category: Category) = repository.create(category)

}