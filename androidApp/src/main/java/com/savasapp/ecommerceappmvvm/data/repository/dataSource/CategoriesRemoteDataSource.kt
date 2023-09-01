package com.savasapp.ecommerceappmvvm.data.repository.dataSource

import com.savasapp.ecommerceappmvvm.domain.model.Category
import com.savasapp.ecommerceappmvvm.domain.repository.Resource
import retrofit2.Response

interface CategoriesRemoteDataSource {

    suspend fun create(category: Category) : Response<Category>

    suspend fun getCategories() : Response<List<Category>>

    suspend fun update(id:Int, category: Category) : Response<Category>

    suspend fun delete(id: Int) : Response<Category>

}