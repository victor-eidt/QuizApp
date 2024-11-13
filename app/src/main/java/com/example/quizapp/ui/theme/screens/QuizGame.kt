package com.example.quizapp.ui.theme.screens

import android.content.Context
import androidx.compose.runtime.*
import com.example.quizapp.data.LeaderboardDao
import com.example.quizapp.data.LeaderboardEntry
import com.example.quizapp.data.Question
import com.example.quizapp.data.Score
import com.example.quizapp.data.QuizDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun QuizGame(
    context: Context,
    questions: List<Question>,
    onQuizEnd: (score: Int) -> Unit
) {
    var currentQuestionIndex by remember { mutableIntStateOf(0) }
    val score = remember { Score() }
    val leaderboardDao = QuizDatabase.getDatabase(context).leaderboardDao()
    var shuffledQuestions by remember { mutableStateOf(questions.shuffled()) }
    var questionStartTime by remember { mutableLongStateOf(System.currentTimeMillis()) }
    var isQuizFinished by remember { mutableStateOf(false) }

    if (isQuizFinished) {
        // Garante que a tela final seja exibida apenas uma vez
        LaunchedEffect(Unit) {
            saveScoreAndEndQuiz(score.totalScore, leaderboardDao, onQuizEnd)
        }
    } else if (currentQuestionIndex < shuffledQuestions.size) {
        QuestionView(
            question = shuffledQuestions[currentQuestionIndex],
            score = score,
            onAnswerSelected = { isCorrect ->
                if (isCorrect) {
                    val responseTime = (System.currentTimeMillis() - questionStartTime) / 1000
                    val points = score.calculatePoints(responseTime)
                    score.addPoints(points)
                    currentQuestionIndex++

                    // Verifica se todas as perguntas foram respondidas
                    if (currentQuestionIndex >= shuffledQuestions.size) {
                        isQuizFinished = true
                    } else {
                        questionStartTime = System.currentTimeMillis()
                    }
                } else {
                    isQuizFinished = true
                }
            },
            onQuizEnd = {
                isQuizFinished = true
            }
        )
    }
}

private fun saveScoreAndEndQuiz(
    score: Int,
    leaderboardDao: LeaderboardDao,
    onQuizEnd: (score: Int) -> Unit
) {
    CoroutineScope(Dispatchers.IO).launch {
        // Salva a pontuação no banco de dados, evitando duplicatas
        leaderboardDao.insert(LeaderboardEntry(playerName = "Player", score = score))
    }
    onQuizEnd(score) // Redireciona para a tela final
}