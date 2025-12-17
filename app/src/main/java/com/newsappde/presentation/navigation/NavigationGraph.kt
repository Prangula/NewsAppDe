package com.newsappde.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.newsappde.domain.model.ArticleDomain
import com.newsappde.presentation.ui.favorite.FavoriteNewsVm
import com.newsappde.presentation.ui.favorite.FavoriteScreen
import com.newsappde.presentation.ui.home.HomeScreen
import com.newsappde.presentation.ui.home.NewsVm
import com.newsappde.presentation.ui.search.SearchScreen
import com.newsappde.presentation.ui.webView.WebViewScreen
import com.newsappde.presentation.ui.webView.WebViewVm
import org.koin.androidx.compose.koinViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomModel.Home.route
    ) {
        composable(BottomModel.Home.route) {
            val vm: NewsVm = koinViewModel()
            HomeScreen(
                state = vm.state,
                onArticleClick = { article ->
                    navController.currentBackStackEntry?.savedStateHandle?.set("article", article)
                    navController.navigate("web")
                }
            )
        }
        composable("web") {
            val vm: WebViewVm = koinViewModel()
            val article = navController.previousBackStackEntry
                ?.savedStateHandle
                ?.get<ArticleDomain>("article")
                ?: return@composable

            WebViewScreen(article = article, vm = vm)
        }
        composable(BottomModel.Favorites.route) {
            val vm: FavoriteNewsVm = koinViewModel()
            FavoriteScreen(vm = vm, onArticleClick = { favorite ->
                val article = vm.toArticle(favorite) // <-- map here
                navController.currentBackStackEntry?.savedStateHandle?.set("article", article)
                navController.navigate("web")
            })
        }
        composable(BottomModel.Search.route) { SearchScreen() }
    }
}