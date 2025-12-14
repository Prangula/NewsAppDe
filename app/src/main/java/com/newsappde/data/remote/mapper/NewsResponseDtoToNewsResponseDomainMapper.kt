package com.newsappde.data.remote.mapper

import com.newsappde.data.remote.dto.NewsResponseDto
import com.newsappde.domain.model.NewsResponseDomain
import com.newsappde.utils.baseMapper.BaseMapper

class NewsResponseDtoToNewsResponseDomainMapper(
    private val articleMapper: ArticleDtoToArticleDomainMapper
) : BaseMapper<NewsResponseDto, NewsResponseDomain> {
    override fun mapModel(model: NewsResponseDto): NewsResponseDomain {
        return with(model) {
            NewsResponseDomain(
                articles = articleMapper.mapToList(articles),
                status = status,
                totalResults = totalResults
            )
        }
    }
}