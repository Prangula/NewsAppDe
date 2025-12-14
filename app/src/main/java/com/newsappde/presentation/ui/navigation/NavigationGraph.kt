package com.newsappde.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.newsappde.presentation.ui.FavoriteScreen
import com.newsappde.presentation.ui.HomeScreen
import com.newsappde.presentation.ui.SearchScreen
import com.newsappde.presentation.vm.NewsVm
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomModel.Home.route
    ) {
        composable(BottomModel.Home.route) {
            val vm: NewsVm = koinViewModel()
            HomeScreen(state = vm.state)
        }
        composable(BottomModel.Favorites.route) { FavoriteScreen() }
        composable(BottomModel.Search.route) { SearchScreen() }
    }
}