package com.newsappde.di

import com.newsappde.data.local.mapper.FavoriteNewsDomainToEntityMapper
import com.newsappde.data.local.mapper.FavoriteNewsEntityToDomainMapper
import com.newsappde.data.remote.mapper.ArticleDomainToArticleDtoMapper
import com.newsappde.data.remote.mapper.ArticleDomainToArticleFavoriteMapper
import com.newsappde.data.remote.mapper.ArticleDtoToArticleDomainMapper
import com.newsappde.data.remote.mapper.FavoriteArticleDomainToArticleDomainMapper
import com.newsappde.data.remote.mapper.NewsResponseDtoToNewsResponseDomainMapper
import com.newsappde.data.remote.mapper.SourceDomainToSourceDtoMapper
import com.newsappde.data.remote.mapper.SourceDtoToSourceDomainMapper
import org.koin.dsl.module

val mapperModule = module {
    single { ArticleDtoToArticleDomainMapper(sourceMapper = get()) }
    single { NewsResponseDtoToNewsResponseDomainMapper(articleMapper = get()) }
    single { SourceDtoToSourceDomainMapper() }
    single { FavoriteNewsEntityToDomainMapper() }
    single { FavoriteNewsDomainToEntityMapper() }
    single { ArticleDomainToArticleDtoMapper(sourceMapper = get()) }
    single { SourceDomainToSourceDtoMapper() }
    single { ArticleDomainToArticleFavoriteMapper() }
    single { FavoriteArticleDomainToArticleDomainMapper() }
}