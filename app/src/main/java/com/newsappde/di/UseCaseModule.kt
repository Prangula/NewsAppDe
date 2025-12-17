package com.newsappde.di

import com.newsappde.domain.use_case.DeleteFavoriteNewsUseCaseImpl
import com.newsappde.domain.use_case.GetFavoriteNewsUseCase
import com.newsappde.domain.use_case.GetFavoriteNewsUseCaseImpl
import com.newsappde.domain.use_case.InsertFavoriteNewsUseCaseImpl
import com.newsappde.domain.use_case.NewsUseCase
import com.newsappde.domain.use_case.NewsUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<NewsUseCase> { NewsUseCaseImpl(newsRepository = get()) }
    single<InsertFavoriteNewsUseCaseImpl> {
        InsertFavoriteNewsUseCaseImpl(
            favoriteNewsRepository = get()
        )
    }
    single<DeleteFavoriteNewsUseCaseImpl> {
        DeleteFavoriteNewsUseCaseImpl(
            favoriteNewsRepository = get()
        )
    }
    single<GetFavoriteNewsUseCase> { GetFavoriteNewsUseCaseImpl(favoriteNewsRepository = get()) }
}