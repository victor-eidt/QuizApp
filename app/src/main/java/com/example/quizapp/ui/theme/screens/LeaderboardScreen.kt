package com.example.quizapp.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.data.LeaderboardRepository
import com.example.quizapp.ui.theme.poppins

@Composable
fun LeaderboardScreen() {
    val leaderboard = LeaderboardRepository.getLeaderboard()

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
            items(leaderboard) { entry ->
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
