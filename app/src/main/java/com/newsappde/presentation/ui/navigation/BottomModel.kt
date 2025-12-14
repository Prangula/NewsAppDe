package com.newsappde.presentation.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.newsappde.utils.constants.Strings.FAVORITES
import com.newsappde.utils.constants.Strings.HOME
import com.newsappde.utils.constants.Strings.SEARCH

sealed class BottomModel(val route: String, val title: String, val icon: ImageVector) {
    data object Home : BottomModel(route = HOME, title = HOME, icon = Icons.Default.Home)
    data object Favorites :
        BottomModel(route = FAVORITES, title = FAVORITES, icon = Icons.Default.Favorite)
    data object Search : BottomModel(route = SEARCH, title = SEARCH, icon = Icons.Default.Search)
}
