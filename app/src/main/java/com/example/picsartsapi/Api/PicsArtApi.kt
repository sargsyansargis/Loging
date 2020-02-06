package com.example.picsartsapi.Api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface PicsArtApi {
    @POST("users/")
    fun getUser(@Body user: String): Deferred<LoginResponse>


    companion object {
        private var BACE_URL = "https://api.picsart.com/"

//        private var httpClient = OkHttpClient.Builder()
//            .addInterceptor(HttpLoggingInterceptor().apply {
//                level = HttpLoggingInterceptor.Level.BODY
//            })

        private var retrofit = Retrofit.Builder()
//            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl(BACE_URL)
            .build()

        fun getApi(): PicsArtApi {
            return retrofit.create(PicsArtApi::class.java)
        }
    }
}