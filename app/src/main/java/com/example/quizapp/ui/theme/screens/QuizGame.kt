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

    if (currentQuestionIndex < shuffledQuestions.size) {
        QuestionView(
            question = shuffledQuestions[currentQuestionIndex],
            score = score,
            onAnswerSelected = { isCorrect ->
                if (isCorrect) {
                    val responseTime = (System.currentTimeMillis() - questionStartTime) / 1000
                    val points = score.calculatePoints(responseTime)
                    score.addPoints(points)
                    currentQuestionIndex++
                    questionStartTime = System.currentTimeMillis()
                } else {
                    saveScoreAndEndQuiz(score.totalScore, leaderboardDao, onQuizEnd)
                }
            },
            onQuizEnd = {
                saveScoreAndEndQuiz(score.totalScore, leaderboardDao, onQuizEnd)
            }
        )
    } else {
        saveScoreAndEndQuiz(score.totalScore, leaderboardDao, onQuizEnd)
    }
}

private fun saveScoreAndEndQuiz(
    score: Int,
    leaderboardDao: LeaderboardDao,
    onQuizEnd: (score: Int) -> Unit
) {
    CoroutineScope(Dispatchers.IO).launch {
        leaderboardDao.insert(LeaderboardEntry(playerName = "Player", score = score))
    }
    onQuizEnd(score) // Redireciona para a tela final
}