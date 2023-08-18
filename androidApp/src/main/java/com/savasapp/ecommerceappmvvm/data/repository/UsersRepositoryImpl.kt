package com.savasapp.ecommerceappmvvm.data.repository


import android.util.Log
import com.savasapp.ecommerceappmvvm.data.repository.dataSource.AuthLocalDataSource
import com.savasapp.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.savasapp.ecommerceappmvvm.data.repository.dataSource.UsersRemoteDataSource
import com.savasapp.ecommerceappmvvm.domain.model.ErrorMessage
import com.savasapp.ecommerceappmvvm.domain.model.AuthResponse
import com.savasapp.ecommerceappmvvm.domain.model.RegisterResponse
import com.savasapp.ecommerceappmvvm.domain.model.User
import com.savasapp.ecommerceappmvvm.domain.repository.AuthRepository
import com.savasapp.ecommerceappmvvm.domain.repository.Resource
import com.savasapp.ecommerceappmvvm.domain.repository.UserRepository
import com.savasapp.ecommerceappmvvm.domain.util.ConvertErrorBody
import com.savasapp.ecommerceappmvvm.presentation.screens.auth.login.LoginState
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.IOException


class UsersRepositoryImpl(private val usersRemoteDataSource: UsersRemoteDataSource
                         ) : UserRepository
{
    override suspend fun update(user: User): Resource<User> {
        return try {
            val result = usersRemoteDataSource.update(user)

            val error = result.code()
            val desc = result.message()

            if (result.isSuccessful){
                Resource.Success(result.body()!!)
            }
            else{
                val errorMessage : ErrorMessage? = ConvertErrorBody.converterErrorBody(result.errorBody())
                Resource.Failure(errorMessage?.errorDesc ?: "Error desconocido")
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