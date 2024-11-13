package com.example.quizapp.data

object LeaderboardRepository {
    private val leaderboard = mutableListOf<LeaderboardEntry>()

    fun addScore(playerName: String, score: Int) {
        leaderboard.add(LeaderboardEntry(playerName, score))
        leaderboard.sortByDescending { it.score }
        if (leaderboard.size > 10) {
            leaderboard.removeLast()
        }
    }

    fun getLeaderboard(): List<LeaderboardEntry> = leaderboard
}
