package com.newsappde.data.local.mapper

import com.newsappde.data.local.entity.FavoriteNewsEntity
import com.newsappde.domain.model.FavoriteNewsDomain
import com.newsappde.utils.baseMapper.BaseMapper

class FavoriteNewsDomainToEntityMapper : BaseMapper<FavoriteNewsDomain, FavoriteNewsEntity> {
    override fun mapModel(model: FavoriteNewsDomain): FavoriteNewsEntity {
        return with(model) {
            FavoriteNewsEntity(
                url = url,
                author = author,
                description = description,
                publishedAt = publishedAt,
                title = title,
                urlToImage = urlToImage
            )
        }
    }
}