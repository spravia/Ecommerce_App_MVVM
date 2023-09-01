package com.savasapp.ecommerceappmvvm.data.service

import com.savasapp.ecommerceappmvvm.domain.model.Category
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface CategoryService {


    @GET("api/categories")
    @Headers("Content-Type:application/json; charset=utf-8")
    suspend fun getCategories() : Response<List<Category>>

    @POST("api/categories/addcategorie")
    @Headers("Content-Type:application/json; charset=utf-8")
    suspend fun create(@Body category: Category) : Response<Category>


    @PUT("api/categories/updatecategorie")
    @Headers("Content-Type:application/json; charset=utf-8")
    suspend fun update(
        @Query("id") id :Int, @Body category: Category
    ) : Response<Category>

    @DELETE("api/categories/deletecatetorie")
    @Headers("Content-Type:application/json; charset=utf-8")
    suspend fun delete(@Query("id") id :Int): Response<Unit>

}