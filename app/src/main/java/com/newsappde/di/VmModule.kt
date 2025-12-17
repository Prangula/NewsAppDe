package com.newsappde.di

import com.newsappde.presentation.ui.favorite.FavoriteNewsVm
import com.newsappde.presentation.ui.home.NewsVm
import com.newsappde.presentation.ui.webView.WebViewVm
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val vmModule = module {
    viewModel { NewsVm(newsUseCase = get()) }
    viewModel {
        WebViewVm(
            insertFavoriteUseCase = get(),
            articleDomainToArticleFavoriteMapper = get()
        )
    }
    viewModel {
        FavoriteNewsVm(
            deleteFavoriteUseCase = get(),
            getFavoriteNewsUseCase = get(),
            mapper = get()
        )
    }
}