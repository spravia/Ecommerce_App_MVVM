package com.savasapp.ecommerceappmvvm.data.repository

import android.util.Log
import com.savasapp.ecommerceappmvvm.data.repository.dataSource.CategoriesRemoteDataSource
import com.savasapp.ecommerceappmvvm.domain.model.Category
import com.savasapp.ecommerceappmvvm.domain.repository.CategoryRepository
import com.savasapp.ecommerceappmvvm.domain.repository.Resource
import com.savasapp.ecommerceappmvvm.domain.util.ResponseToRequest
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.HttpException
import java.io.IOException

class CategoriesRepositoryImpl(private val categoriesRemoteDataSource : CategoriesRemoteDataSource) : CategoryRepository {
    override suspend fun create(category: Category): Resource<Category> {

        return try {
            val result = categoriesRemoteDataSource.create(category)

            val error = result.code()
            val desc = result.message()

            if (result.isSuccessful)
            {
                Resource.Success(result.body()!!)
            }
            else{
                //val errorMessage : ErrorResponse? = ConvertErrorBody.converterErrorBody(result.errorBody())
                Resource.Failure("$error:  $desc")
            }
        }catch (e : HttpException) {
            Log.d("AuthRepositoryImpl","Error:" + e)
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconocido en la peticiòn Http")
        }
        catch (e : IOException) {
            Log.d("AuthRepositoryImpl","Error:" + e)
            e.printStackTrace()
            Resource.Failure(e.message ?: "Verica tu conexiòn")
        }
        catch (e : Exception) {
            Log.d("AuthRepositoryImpl","Error:" + e)
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconocido")
        }
    }

    override fun getCatetories(): Flow<Resource<List<Category>>> = callbackFlow  {
        trySend(ResponseToRequest.send(categoriesRemoteDataSource.getCategories()) )
        awaitClose { close() }
    }

    override suspend fun update(id: Int, category: Category): Resource<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: Int): Resource<Unit> {
        TODO("Not yet implemented")
    }
}