package com.newsappde.presentation.state

import com.newsappde.domain.model.NewsResponseDomain

data class NewsState(
    val newsList: NewsResponseDomain? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)