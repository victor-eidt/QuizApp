package com.example.quizapp.ui.theme.screens

import androidx.compose.runtime.*
import com.example.quizapp.data.Question
import com.example.quizapp.data.Score
import com.example.quizapp.data.LeaderboardRepository

@Composable
fun QuizGame(questions: List<Question>, onQuizEnd: (score: Int) -> Unit) {
    var currentQuestionIndex by remember { mutableIntStateOf(0) }
    val score = remember { Score() }
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
                    saveScoreAndEndQuiz(score.totalScore, onQuizEnd)
                }
            },
            onQuizEnd = { saveScoreAndEndQuiz(score.totalScore, onQuizEnd) }
        )
    } else {
        saveScoreAndEndQuiz(score.totalScore, onQuizEnd)
    }
}

private fun saveScoreAndEndQuiz(score: Int, onQuizEnd: (score: Int) -> Unit) {
    LeaderboardRepository.addScore("Player", score)
    onQuizEnd(score)
}
