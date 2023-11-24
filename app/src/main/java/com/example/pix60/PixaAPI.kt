package com.example.pix60

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixaAPI {

    @GET("api/")
    fun getImages(
        @Query("key") key: String = "40862025-c2e46359b922fef3276a66b9f",
        @Query("q") keyWord: String
    ): Call<PixaModel>
}