package com.newsappde

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.rememberNavController
import com.newsappde.ui.navigation.BottomNavBar
import com.newsappde.ui.navigation.NavigationGraph
import com.newsappde.ui.theme.NewsAppDeTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NewsAppDeTheme {
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
