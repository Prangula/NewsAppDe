package com.newsappde.presentation.ui.webView

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.newsappde.data.remote.mapper.ArticleDomainToArticleFavoriteMapper
import com.newsappde.domain.model.ArticleDomain
import com.newsappde.domain.use_case.InsertFavoriteNewsUseCaseImpl
import com.newsappde.utils.extensions.viewModelScope

class WebViewVm(
    private val insertFavoriteUseCase: InsertFavoriteNewsUseCaseImpl,
    private val articleDomainToArticleFavoriteMapper: ArticleDomainToArticleFavoriteMapper
) : ViewModel() {

    @RequiresApi(Build.VERSION_CODES.O)
    fun onAction(
        action: WebViewAction,
        articleDomain: ArticleDomain
    ) {
        when (action) {
            WebViewAction.AddToFavorites -> {
                insertFavoriteNews(articleDomain)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun insertFavoriteNews(articleDomain: ArticleDomain) {
        viewModelScope {
            insertFavoriteUseCase(
                data = articleDomainToArticleFavoriteMapper.mapModel(articleDomain)
            )
        }
    }
}