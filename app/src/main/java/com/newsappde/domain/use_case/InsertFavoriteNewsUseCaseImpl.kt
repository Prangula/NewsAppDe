package com.newsappde.domain.use_case

import com.newsappde.domain.model.FavoriteNewsDomain
import com.newsappde.domain.repository.FavoriteNewsRepository

class InsertFavoriteNewsUseCaseImpl(
    private val favoriteNewsRepository: FavoriteNewsRepository
) : FavoriteBaseUseCase<FavoriteNewsDomain, Unit> {
    override suspend fun invoke(data: FavoriteNewsDomain?) {
        favoriteNewsRepository.insert(data!!)
    }
}