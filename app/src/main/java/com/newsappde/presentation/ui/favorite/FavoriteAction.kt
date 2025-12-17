package com.newsappde.presentation.ui.favorite

import com.newsappde.domain.model.FavoriteNewsDomain

interface FavoriteAction {
    data class DeleteArticle(val article: FavoriteNewsDomain) : FavoriteAction
}