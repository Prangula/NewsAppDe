package com.newsappde.di

import com.newsappde.data.remote.repository.NewsRepositoryImpl
import com.newsappde.domain.repository.NewsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<NewsRepository> { NewsRepositoryImpl(newsApi = get(), newsResponseMapper = get()) }
}