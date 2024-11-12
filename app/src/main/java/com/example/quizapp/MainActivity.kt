package com.example.quizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizapp.data.QuestionRepository
import com.example.quizapp.ui.theme.screens.LeaderboardScreen
import com.example.quizapp.ui.theme.screens.QuizGame
import com.example.quizapp.ui.theme.screens.StartScreen

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

        composable("quiz") {
            QuizGame(
                questions = QuestionRepository.questions,
                onQuizEnd = { score ->
                    println("Pontuação final: $score")
                    navController.navigate("start")
                }
            )
        }

        composable("leaderboard") { LeaderboardScreen() }
    }
}
