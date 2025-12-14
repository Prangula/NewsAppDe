package com.newsappde.data.remote.api

import com.newsappde.data.remote.dto.NewsResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    suspend fun getNews(
        @Query("country") country: String = "de"
    ): NewsResponseDto
}