package com.newsappde.presentation.ui.webView

sealed interface WebViewAction {
    data object AddToFavorites : WebViewAction
}