package com.newsappde.data.local.repository

import com.newsappde.data.local.dao.FavoriteNewsDao
import com.newsappde.data.local.mapper.FavoriteNewsDomainToEntityMapper
import com.newsappde.data.local.mapper.FavoriteNewsEntityToDomainMapper
import com.newsappde.domain.model.FavoriteNewsDomain
import com.newsappde.domain.repository.FavoriteNewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavoriteNewsRepositoryImpl(
    private val favoriteNewsDao: FavoriteNewsDao,
    private val favoriteNewsEntityToDomainMapper: FavoriteNewsEntityToDomainMapper,
    private val favoriteNewsDomainToEntityMapper: FavoriteNewsDomainToEntityMapper
) : FavoriteNewsRepository {
    override suspend fun insert(favoriteNewsDomain: FavoriteNewsDomain) {
        favoriteNewsDao.insertNews(
            favoriteNewsDomainToEntityMapper.mapModel(favoriteNewsDomain)
        )
    }

    override suspend fun delete(favoriteNewsDomain: FavoriteNewsDomain) {
        favoriteNewsDao.deleteNews(
            favoriteNewsDomainToEntityMapper.mapModel(favoriteNewsDomain)
        )
    }

    override fun getAllNews(): Flow<List<FavoriteNewsDomain>> {
        return favoriteNewsDao.getAllNews().map {
            favoriteNewsEntityToDomainMapper.mapToList(it)
        }
    }
}