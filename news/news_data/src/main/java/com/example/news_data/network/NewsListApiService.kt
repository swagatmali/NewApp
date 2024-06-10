package com.example.news_data.network

import com.example.common_util.AppConstants
import com.example.news_data.model.NewListResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsListApiService {

    // https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=027d5edb79dd406d91b567a90eec4c03

    @GET("top-headlines")
    suspend fun getArticles(
        @Query("country") country: String = AppConstants.COUNTRY,
        @Query("category") category: String = AppConstants.CATEGORY,
        @Query("apiKey") apiKey: String = AppConstants.API_KEY
    ):NewListResponseDTO
}