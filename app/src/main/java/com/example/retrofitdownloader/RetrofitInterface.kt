package com.example.retrofitdownloader

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Streaming


interface RetrofitInterface {

    @Streaming
    @GET("/resource/example.zip")
    suspend fun downloadFile():Response<ResponseBody>


}