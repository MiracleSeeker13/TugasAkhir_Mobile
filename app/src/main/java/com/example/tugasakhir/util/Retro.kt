package com.example.tugasakhir.util

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retro {
    fun getRetroClientInstance(): Retrofit{
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
    companion object{
        private const val BASE_URL ="http://192.168.67.196/ta_mobile/public/api/"
    }
}