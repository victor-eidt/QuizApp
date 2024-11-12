package com.example.quizapp.data

data class Score(var totalScore: Int = 0) {

    fun calculatePoints(responseTime: Long): Int {
        return when {
            responseTime < 5 -> 10
            responseTime < 10 -> 7
            else -> 5
        }
    }

    fun addPoints(points: Int) {
        totalScore += points
    }
}
