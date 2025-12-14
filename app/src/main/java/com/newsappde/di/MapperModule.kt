package com.newsappde.di

import com.newsappde.data.remote.mapper.ArticleDtoToArticleDomainMapper
import com.newsappde.data.remote.mapper.NewsResponseDtoToNewsResponseDomainMapper
import com.newsappde.data.remote.mapper.SourceDtoToSourceDomainMapper
import org.koin.dsl.module

val mapperModule = module {
    single { ArticleDtoToArticleDomainMapper(sourceMapper = get()) }
    single { NewsResponseDtoToNewsResponseDomainMapper(articleMapper = get()) }
    single { SourceDtoToSourceDomainMapper() }
}