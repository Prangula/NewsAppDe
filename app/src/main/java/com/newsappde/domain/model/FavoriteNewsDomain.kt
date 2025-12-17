package com.newsappde.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FavoriteNewsDomain(
    val url: String = "",
    val author: String = "",
    val description: String = "",
    val publishedAt: String = "",
    val title: String = "",
    val urlToImage: String = ""
) : Parcelable
