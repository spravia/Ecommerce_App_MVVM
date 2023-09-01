package com.savasapp.ecommerceappmvvm.domain.repository

import com.savasapp.ecommerceappmvvm.domain.model.Category
import kotlinx.coroutines.flow.Flow


interface CategoryRepository {

    suspend fun create(category: Category ) : Resource<Category>

    //TODO si usamos Flow no se requiere la palabra suspend
    fun getCatetories(): Flow<Resource<List<Category>>>

    suspend fun update(id : Int, category: Category) : Resource<Category>

    //TODO cuanod no se requiere retornar nada en la llamada
    suspend fun delete(id:Int) : Resource<Unit>



}