package com.newsappde.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class ArticleDomain(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: @RawValue SourceDomain,
    val title: String?,
    val url: String?,
    val urlToImage: String?
) : Parcelable