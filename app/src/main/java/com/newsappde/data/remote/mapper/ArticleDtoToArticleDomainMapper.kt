package com.newsappde.data.remote.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.newsappde.data.remote.dto.ArticleDto
import com.newsappde.domain.model.ArticleDomain
import com.newsappde.utils.baseMapper.BaseMapper
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class ArticleDtoToArticleDomainMapper(
    private val sourceMapper: SourceDtoToSourceDomainMapper
) : BaseMapper<ArticleDto, ArticleDomain> {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun mapModel(model: ArticleDto): ArticleDomain {
        return with(model) {
            val formattedTime = publishedAt?.let {
                try {
                    val zoned = ZonedDateTime.parse(it)
                    zoned.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                } catch (e: Exception) {
                    it
                }
            }
            ArticleDomain(
                author = author,
                content = content,
                description = description,
                publishedAt = formattedTime,
                source = sourceMapper.mapModel(source),
                title = title,
                url = url,
                urlToImage = urlToImage
            )
        }
    }
}