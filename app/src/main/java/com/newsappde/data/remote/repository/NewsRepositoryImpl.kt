package com.newsappde.data.remote.repository

import com.newsappde.data.remote.api.NewsApi
import com.newsappde.data.remote.mapper.NewsResponseDtoToNewsResponseDomainMapper
import com.newsappde.domain.model.NewsResponseDomain
import com.newsappde.domain.repository.NewsRepository
import com.newsappde.utils.constants.Strings
import com.newsappde.utils.resource.Resource

class NewsRepositoryImpl(
    private val newsApi: NewsApi,
    private val newsResponseMapper: NewsResponseDtoToNewsResponseDomainMapper
) : NewsRepository {
    override suspend fun getNews(): Resource<NewsResponseDomain> {
        return try {
            Resource.Success(
                data = newsResponseMapper.mapModel(
                    newsApi.getNews()
                )
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: Strings.UNKNOWN_ERROR)
        }
    }
}