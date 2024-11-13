package com.example.quizapp.ui.theme.screens

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.data.LeaderboardEntry
import com.example.quizapp.data.QuizDatabase
import com.example.quizapp.ui.theme.poppins
import kotlinx.coroutines.flow.Flow

@Composable
fun LeaderboardScreen(context: Context) {
    val leaderboardDao = remember { QuizDatabase.getDatabase(context).leaderboardDao() }
    val leaderboard = leaderboardDao.getTopScores().collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Leaderboard",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = poppins,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(leaderboard.value) { entry ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = entry.playerName,
                        fontSize = 18.sp,
                        fontFamily = poppins
                    )
                    Text(
                        text = "${entry.score}",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = poppins
                    )
                }
            }
        }
    }
}
