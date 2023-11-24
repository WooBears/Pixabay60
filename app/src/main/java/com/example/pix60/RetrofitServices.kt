package com.example.pix60

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//https://pixabay.com/api/
object RetrofitServices {

    private val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://pixabay.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    val api: PixaAPI = retrofit.create(PixaAPI::class.java)
}