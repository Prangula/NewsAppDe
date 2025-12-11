package com.newsappde.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.newsappde.ui.theme.BottomNavBackground
import com.newsappde.ui.theme.BottomNavSelected
import com.newsappde.ui.theme.BottomNavUnselected

@Composable
fun BottomNavBar(navController: NavHostController) {
    val items = listOf(
        BottomModel.Home,
        BottomModel.Favorites,
        BottomModel.Search
    )

    NavigationBar(containerColor = BottomNavBackground) {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        items.forEach { item ->
            val selected = currentRoute == item.route
            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = if (selected) BottomNavSelected else BottomNavUnselected
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color = if (selected) BottomNavSelected else BottomNavUnselected
                    )
                }
            )
        }
    }
}