package com.newsappde.domain.model

data class NewsResponseDomain(
    val articles: List<ArticleDomain>,
    val status: String,
    val totalResults: Int
)
