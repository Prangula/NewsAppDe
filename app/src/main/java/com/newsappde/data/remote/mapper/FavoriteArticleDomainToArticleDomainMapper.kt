package com.newsappde.data.remote.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.newsappde.domain.model.ArticleDomain
import com.newsappde.domain.model.FavoriteNewsDomain
import com.newsappde.domain.model.SourceDomain
import com.newsappde.utils.baseMapper.BaseMapper
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class FavoriteArticleDomainToArticleDomainMapper : BaseMapper<FavoriteNewsDomain, ArticleDomain> {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun mapModel(model: FavoriteNewsDomain): ArticleDomain {
        return with(model) {
            val formattedTime = publishedAt.let {
                try {
                    val zoned = ZonedDateTime.parse(it)
                    zoned.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                } catch (e: Exception) {
                    it
                }
            }
            ArticleDomain(
                author = author,
                description = description,
                publishedAt = formattedTime.orEmpty(),
                title = title,
                url = url,
                urlToImage = urlToImage,
                content = "",
                source = SourceDomain(
                    id = "",
                    name = ""
                ),
            )
        }
    }
}