package com.newsappde.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.newsappde.utils.constants.Strings.NEWS_TABLE

@Entity(tableName = NEWS_TABLE)
data class FavoriteNewsEntity(
    @PrimaryKey val url: String = "",
    val author: String?,
    val description: String?,
    val publishedAt: String?,
    val title: String?,
    val urlToImage: String?
)
