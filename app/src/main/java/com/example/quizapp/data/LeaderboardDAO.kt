package com.example.quizapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LeaderboardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entry: LeaderboardEntry)

    @Query("SELECT * FROM leaderboard_table ORDER BY score DESC LIMIT 10")
    fun getTopScores(): kotlinx.coroutines.flow.Flow<List<LeaderboardEntry>>

    @Query("SELECT COUNT(*) FROM leaderboard_table WHERE playerName = :playerName AND score = :score")
    suspend fun countEntries(playerName: String, score: Int): Int
}

