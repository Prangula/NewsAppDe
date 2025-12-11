package com.newsappde.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.newsappde.ui.FavoriteScreen
import com.newsappde.ui.HomeScreen
import com.newsappde.ui.SearchScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomModel.Home.route
    ) {
        composable(BottomModel.Home.route) { HomeScreen() }
        composable(BottomModel.Favorites.route) { FavoriteScreen() }
        composable(BottomModel.Search.route) { SearchScreen() }
    }
}