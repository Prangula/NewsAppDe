package com.newsappde.presentation.ui.favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.newsappde.domain.model.FavoriteNewsDomain
import com.newsappde.presentation.ui.theme.CardBackground
import com.newsappde.presentation.ui.theme.ScreenBackground

@Composable
fun FavoriteScreen(
    vm: FavoriteNewsVm,
    onArticleClick: (FavoriteNewsDomain) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(ScreenBackground)
    )
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 60.dp)
    ) {
        items(vm.favoriteNews) { article ->
            FavoriteNewsCard(
                favoriteNewsDomain = article,
                cardBackgroundColor = CardBackground,
                onClick = { onArticleClick(article) },
                onLongClick = { vm.onAction(FavoriteAction.DeleteArticle(article)) }
            )
        }
    }
}