package com.newsappde

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.material3.Scaffold
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.newsappde.presentation.navigation.BottomNavBar
import com.newsappde.presentation.navigation.NavigationGraph
import com.newsappde.presentation.ui.theme.NewsAppDeTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NewsAppDeTheme {
                splashScreen.setKeepOnScreenCondition { false }
                Scaffold(
                    bottomBar = {
                        val currentRoute =
                            navController.currentBackStackEntryAsState().value?.destination?.route
                        if (currentRoute != "web") {
                            BottomNavBar(navController)
                        }

                    }
                ) {
                    NavigationGraph(navController)
                }
            }
        }
    }
}
