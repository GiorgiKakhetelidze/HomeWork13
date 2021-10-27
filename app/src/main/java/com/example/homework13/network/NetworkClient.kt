package com.example.homework13.network

import com.example.homework13.model.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkClient {

    val rentService by lazy { createRentNewsService() }

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private fun createRentNewsService(): NewsService {
        val retrofitBuilder = Retrofit.Builder()
        retrofitBuilder.baseUrl("https://run.mocky.io/v3/")
        retrofitBuilder.client(
            OkHttpClient().newBuilder()
                .addInterceptor(loggingInterceptor)
                .build()
        )
        retrofitBuilder.addConverterFactory(moshConverter())
        return retrofitBuilder.build().create(NewsService::class.java)
    }

    private fun moshConverter() =
        MoshiConverterFactory.create(
            Moshi.Builder()
                .add(JsonAdapter)
                .addLast(KotlinJsonAdapterFactory())
                .build()
        )
}