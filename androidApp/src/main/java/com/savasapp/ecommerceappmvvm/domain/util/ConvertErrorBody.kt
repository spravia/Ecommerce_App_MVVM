package com.savasapp.ecommerceappmvvm.domain.util

import android.util.Log
import com.savasapp.ecommerceappmvvm.domain.model.ErrorMessage

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.ResponseBody


object ConvertErrorBody {

    fun converterErrorBody(errorBody: ResponseBody?) : ErrorMessage? {

        return  try {

                errorBody?.source().let {
                    val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
                    val moshiAdapter = moshi.adapter(ErrorMessage::class.java)
                    moshiAdapter.fromJson(it)
                }
            }catch (e: Exception){
                Log.d("","")
                null
            }
    }
}