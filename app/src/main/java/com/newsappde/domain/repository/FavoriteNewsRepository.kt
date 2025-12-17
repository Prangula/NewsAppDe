package com.newsappde.domain.repository

import com.newsappde.domain.model.FavoriteNewsDomain
import kotlinx.coroutines.flow.Flow

interface FavoriteNewsRepository {
    suspend fun insert(favoriteNewsDomain: FavoriteNewsDomain)
    suspend fun delete(favoriteNewsDomain: FavoriteNewsDomain)
    fun getAllNews(): Flow<List<FavoriteNewsDomain>>
}