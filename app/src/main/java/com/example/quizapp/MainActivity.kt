package com.example.quizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.quizapp.data.QuestionRepository
import com.example.quizapp.ui.theme.screens.LeaderboardScreen
import com.example.quizapp.ui.theme.screens.QuizGame
import com.example.quizapp.ui.theme.screens.StartScreen
import com.example.quizapp.ui.theme.screens.TelaFinal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "start") {
        composable("start") {
            StartScreen(
                onStartQuiz = { navController.navigate("quiz") },
                onViewLeaderboard = { navController.navigate("leaderboard") }
            )
        }

        composable(
            route = "final/{score}",
            arguments = listOf(navArgument("score") { type = NavType.IntType })
        ) { backStackEntry ->
            val score = backStackEntry.arguments?.getInt("score") ?: 0
            TelaFinal(
                score = score,
                onBackToStart = {
                    navController.navigate("start") {
                        popUpTo("final") { inclusive = true }
                    }
                }
            )
        }
    }
}