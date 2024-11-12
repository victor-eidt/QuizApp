package com.example.quizapp.ui.theme.screens

import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.R
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.style.TextAlign
import com.example.quizapp.ui.theme.poppins

@Composable
fun StartScreen(onStartQuiz: () -> Unit = {}, onViewLeaderboard: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_image), // Substitua pelo nome da sua imagem de fundo
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_header_image), // Substitua pelo nome da sua imagem de cabeçalho
                contentDescription = "Imagem de cabeçalho",
                modifier = Modifier
                    .size(200.dp)
                    .padding(bottom = 16.dp),
                contentScale = ContentScale.Fit
            )

            Text(
                text = "Bem-vindo ao ProgrammingQuiz",
                fontSize = 24.sp,
                color = Color.White,
                fontFamily = poppins,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 32.dp),
                textAlign = TextAlign.Center
            )

            Button(
                onClick = onStartQuiz,
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    Color.White
                )
            ) {
                Text(
                    text = "Iniciar Quiz",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontFamily = poppins
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onViewLeaderboard,
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    Color.White
                )
            ) {
                Text(
                    text = "Leaderboard",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontFamily = poppins
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStartScreen() {
    StartScreen()
}