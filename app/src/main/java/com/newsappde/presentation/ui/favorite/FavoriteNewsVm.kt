package com.newsappde.presentation.ui.favorite

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.newsappde.data.remote.mapper.FavoriteArticleDomainToArticleDomainMapper
import com.newsappde.domain.model.ArticleDomain
import com.newsappde.domain.model.FavoriteNewsDomain
import com.newsappde.domain.use_case.DeleteFavoriteNewsUseCaseImpl
import com.newsappde.domain.use_case.GetFavoriteNewsUseCase
import com.newsappde.utils.extensions.viewModelScope

class FavoriteNewsVm(
    private val deleteFavoriteUseCase: DeleteFavoriteNewsUseCaseImpl,
    private val getFavoriteNewsUseCase: GetFavoriteNewsUseCase,
    private val mapper: FavoriteArticleDomainToArticleDomainMapper
) : ViewModel() {

    var favoriteNews by mutableStateOf<List<FavoriteNewsDomain>>(emptyList())
        private set

    fun onAction(action: FavoriteAction) {
        when (action) {
            is FavoriteAction.DeleteArticle -> deleteFavoriteNews(action.article)
        }
    }

    init {
        getAllFavoriteNews()
    }

    private fun getAllFavoriteNews() {
        viewModelScope {
            getFavoriteNewsUseCase.invoke().collect { list ->
                favoriteNews = list.map { it }
            }
        }
    }

    private fun deleteFavoriteNews(news: FavoriteNewsDomain) {
        viewModelScope {
            deleteFavoriteUseCase(data = news)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun toArticle(favorite: FavoriteNewsDomain): ArticleDomain = mapper.mapModel(favorite)
}