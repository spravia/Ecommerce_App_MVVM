package com.savasapp.ecommerceappmvvm.data.repository

import android.util.Log
import com.savasapp.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.savasapp.ecommerceappmvvm.domain.model.ErrorResponse
import com.savasapp.ecommerceappmvvm.domain.model.User
import com.savasapp.ecommerceappmvvm.domain.repository.AuthRepository
import com.savasapp.ecommerceappmvvm.domain.repository.Resource
import com.savasapp.ecommerceappmvvm.domain.util.ConvertErrorBody
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.LoginState
import retrofit2.HttpException
import java.io.IOException

class AuthRepositoryImpl(private val authRemoteDataSource : AuthRemoteDataSource) : AuthRepository
{
    override suspend fun login(loginData : LoginState ): Resource<User>
    {

        return try {
            val result = authRemoteDataSource.login(loginData)

            val error = result.code()
            val desc = result.message()

            if (result.isSuccessful){
                Resource.Success(result.body()!!)
            }
            else{
                val errorMessage : ErrorResponse? = ConvertErrorBody.converterErrorBody(result.errorBody())
                Resource.Failure("$error:  $desc")
            }
        }
        catch (e : HttpException) {
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
}