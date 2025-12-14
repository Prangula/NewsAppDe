package com.newsappde.di

import com.newsappde.domain.use_case.NewsUseCase
import com.newsappde.domain.use_case.NewsUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<NewsUseCase> { NewsUseCaseImpl(newsRepository = get()) }
}