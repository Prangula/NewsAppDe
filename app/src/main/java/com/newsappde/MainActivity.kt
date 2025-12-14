package com.newsappde

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.newsappde.presentation.ui.navigation.BottomNavBar
import com.newsappde.presentation.ui.navigation.NavigationGraph
import com.newsappde.presentation.ui.theme.NewsAppDeTheme

class MainActivity : ComponentActivity() {
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
                        BottomNavBar(navController)
                    }
                ) {
                    NavigationGraph(navController)
                }
            }
        }
    }
}
