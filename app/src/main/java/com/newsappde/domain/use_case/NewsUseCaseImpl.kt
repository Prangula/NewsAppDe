package com.newsappde.domain.use_case

import com.newsappde.domain.model.NewsResponseDomain
import com.newsappde.domain.repository.NewsRepository
import com.newsappde.utils.resource.Resource

class NewsUseCaseImpl(
    private val newsRepository: NewsRepository
) : NewsUseCase {
    override suspend fun invoke(): Resource<NewsResponseDomain> {
        return newsRepository.getNews()
    }
}