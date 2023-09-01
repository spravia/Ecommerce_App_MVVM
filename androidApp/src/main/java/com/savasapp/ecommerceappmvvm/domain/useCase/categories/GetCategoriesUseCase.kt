package com.savasapp.ecommerceappmvvm.domain.useCase.categories


import com.savasapp.ecommerceappmvvm.domain.repository.CategoryRepository

class GetCategoriesUseCase (private val repository: CategoryRepository) {

    suspend fun invoke() = repository.getCatetories()

}