package com.newsappde.domain.use_case

import com.newsappde.domain.model.FavoriteNewsDomain
import com.newsappde.domain.repository.FavoriteNewsRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteNewsUseCaseImpl(
    private val favoriteNewsRepository: FavoriteNewsRepository
) : GetFavoriteNewsUseCase {
    override fun invoke(): Flow<List<FavoriteNewsDomain>> {
        return favoriteNewsRepository.getAllNews()
    }
}