package com.newsappde.domain.use_case

import com.newsappde.domain.model.FavoriteNewsDomain
import kotlinx.coroutines.flow.Flow

interface GetFavoriteNewsUseCase {
    operator fun invoke(): Flow<List<FavoriteNewsDomain>>
}