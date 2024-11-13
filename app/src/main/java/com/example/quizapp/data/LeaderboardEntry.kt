package com.example.quizapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "leaderboard_table")
data class LeaderboardEntry(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val playerName: String,
    val score: Int
)