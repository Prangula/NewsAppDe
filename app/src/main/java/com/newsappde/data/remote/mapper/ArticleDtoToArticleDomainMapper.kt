package com.newsappde.data.remote.mapper

import com.newsappde.data.remote.dto.ArticleDto
import com.newsappde.domain.model.ArticleDomain
import com.newsappde.utils.baseMapper.BaseMapper

class ArticleDtoToArticleDomainMapper(
    private val sourceMapper: SourceDtoToSourceDomainMapper
) : BaseMapper<ArticleDto, ArticleDomain> {
    override fun mapModel(model: ArticleDto): ArticleDomain {
        return with(model) {
            ArticleDomain(
                author = author,
                content = content,
                description = description,
                publishedAt = publishedAt,
                source = sourceMapper.mapModel(source),
                title = title,
                url = url,
                urlToImage = urlToImage
            )
        }
    }
}