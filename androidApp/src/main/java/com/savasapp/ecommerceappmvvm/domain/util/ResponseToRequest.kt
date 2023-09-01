package com.savasapp.ecommerceappmvvm.domain.util

import com.savasapp.ecommerceappmvvm.domain.model.ErrorMessage
import com.savasapp.ecommerceappmvvm.domain.repository.Resource
import retrofit2.Response
import java.io.IOException
import retrofit2.HttpException

object ResponseToRequest {

    fun <T> send(result: Response<T>): Resource<T> {
        return try
        {
            if (result.isSuccessful) { // 201
                Resource.Success(result.body()!!)
            }
            else {
                val errorResponse: ErrorMessage? = ConvertErrorBody.converterErrorBody(result.errorBody())
                Resource.Failure(errorResponse?.errorDesc ?: "Error desconido")
            }
        }
        catch (e: HttpException) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconido en la peticion Http")
        }
        catch (e: IOException) {
            e.printStackTrace()
            Resource.Failure("Verifica tu conexion a internet")
        }
        catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconido")
        }
    }
}