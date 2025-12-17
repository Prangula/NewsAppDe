package com.newsappde.domain.repository

import com.newsappde.domain.model.NewsResponseDomain
import com.newsappde.utils.resource.Resource

interface NewsRepository {
    suspend fun getNews(): Resource<NewsResponseDomain>
}