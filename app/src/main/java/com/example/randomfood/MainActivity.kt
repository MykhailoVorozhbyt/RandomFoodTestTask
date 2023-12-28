package com.example.randomfood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.randomfood.navigation.RootNavGraph
import com.example.core.ui.theme.RandomFoodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomFoodTheme {
                val navGraph = rememberNavController()
                RootNavGraph(navGraph)
            }
        }
    }
}