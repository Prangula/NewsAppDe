package com.newsappde.di

import com.newsappde.data.local.repository.FavoriteNewsRepositoryImpl
import com.newsappde.data.remote.repository.NewsRepositoryImpl
import com.newsappde.domain.repository.FavoriteNewsRepository
import com.newsappde.domain.repository.NewsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<NewsRepository> { NewsRepositoryImpl(newsApi = get(), newsResponseMapper = get()) }
    single<FavoriteNewsRepository> {
        FavoriteNewsRepositoryImpl(
            favoriteNewsDao = get(),
            favoriteNewsEntityToDomainMapper = get(),
            favoriteNewsDomainToEntityMapper = get()
        )
    }
}