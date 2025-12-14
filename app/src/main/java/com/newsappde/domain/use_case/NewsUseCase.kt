package com.newsappde.domain.use_case

import com.newsappde.domain.model.NewsResponseDomain
import com.newsappde.utils.resource.Resource

interface NewsUseCase {
    suspend operator fun invoke(): Resource<NewsResponseDomain>
}