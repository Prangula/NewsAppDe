package com.newsappde.domain.use_case

import com.newsappde.domain.model.FavoriteNewsDomain
import com.newsappde.domain.repository.FavoriteNewsRepository

class DeleteFavoriteNewsUseCaseImpl(
    private val favoriteNewsRepository: FavoriteNewsRepository
) : FavoriteBaseUseCase<FavoriteNewsDomain, Unit> {
    override suspend fun invoke(data: FavoriteNewsDomain?) {
        favoriteNewsRepository.delete(data!!)
    }
}