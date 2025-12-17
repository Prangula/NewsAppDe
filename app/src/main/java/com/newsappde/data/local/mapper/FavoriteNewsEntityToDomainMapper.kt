package com.newsappde.data.local.mapper

import com.newsappde.data.local.entity.FavoriteNewsEntity
import com.newsappde.domain.model.FavoriteNewsDomain
import com.newsappde.utils.baseMapper.BaseMapper

class FavoriteNewsEntityToDomainMapper : BaseMapper<FavoriteNewsEntity, FavoriteNewsDomain> {
    override fun mapModel(model: FavoriteNewsEntity): FavoriteNewsDomain {
        return with(model) {
            FavoriteNewsDomain(
                url = url,
                author = author.orEmpty(),
                description = description.orEmpty(),
                publishedAt = publishedAt.orEmpty(),
                title = title.orEmpty(),
                urlToImage = urlToImage.orEmpty()
            )
        }
    }
}