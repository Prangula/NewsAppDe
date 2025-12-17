package com.newsappde.data.remote.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.newsappde.domain.model.ArticleDomain
import com.newsappde.domain.model.FavoriteNewsDomain
import com.newsappde.utils.baseMapper.BaseMapper
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class ArticleDomainToArticleFavoriteMapper : BaseMapper<ArticleDomain, FavoriteNewsDomain> {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun mapModel(model: ArticleDomain): FavoriteNewsDomain {
        return with(model) {
            val formattedTime = publishedAt?.let {
                try {
                    val zoned = ZonedDateTime.parse(it)
                    zoned.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                } catch (e: Exception) {
                    it
                }
            }
            FavoriteNewsDomain(
                author = author.orEmpty(),
                description = description.orEmpty(),
                publishedAt = formattedTime.orEmpty(),
                title = title.orEmpty(),
                url = url.orEmpty(),
                urlToImage = urlToImage.orEmpty()
            )
        }
    }
}