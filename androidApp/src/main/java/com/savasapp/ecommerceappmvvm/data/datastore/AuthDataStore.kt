package com.savasapp.ecommerceappmvvm.data.datastore

import android.app.AuthenticationRequiredException
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.savasapp.ecommerceappmvvm.core.Config.AUTH_KEY
import com.savasapp.ecommerceappmvvm.domain.model.AuthResponse
import com.savasapp.ecommerceappmvvm.domain.model.User
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class AuthDataStore constructor( private  val dataStore: DataStore<Preferences>)
{

    suspend fun saveUser(authResponse: AuthResponse){
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        dataStore.edit {
                pref -> pref[dataStoreKey] = authResponse.toJson()
                       }
    }


    suspend fun updateUser(user: User){
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        val authResponse= runBlocking {
                getData().first()
        }

        authResponse.name = user.nombres
        authResponse.lastname = user.apellidos
        authResponse.phone = user.telefono
        dataStore.edit {
                pref -> pref[dataStoreKey] = authResponse.toJson()
        }
    }

    suspend fun delete(){
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        dataStore.edit {
                pref -> pref.remove(dataStoreKey)
        }
    }


            //TODO uso de Flow
    fun getData(): Flow<AuthResponse>
    {
            val dataStoreKey = stringPreferencesKey(AUTH_KEY)
            return dataStore.data.map { pref ->
                if (pref[dataStoreKey] != null) {
                    AuthResponse.fromJson(pref[dataStoreKey]!!)
                }
                else{
                    AuthResponse()
                }
            }
    }
}