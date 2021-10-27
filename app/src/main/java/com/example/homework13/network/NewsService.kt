package com.example.homework13.network

import com.example.homework13.model.NewsItem
import retrofit2.Response
import retrofit2.http.GET

interface NewsService {
    @GET("c111ca66-46e7-400e-ab5d-809865408c66")
    suspend fun getNews(): Response<List<NewsItem>>
}