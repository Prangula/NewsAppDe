package com.newsappde.domain.use_case

interface FavoriteBaseUseCase<in DATA, out T> {
    suspend operator fun invoke(data: DATA? = null): T
}