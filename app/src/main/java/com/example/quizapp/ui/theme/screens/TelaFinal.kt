package com.example.quizapp.ui.theme.screens

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.R
import com.example.quizapp.ui.theme.poppins

@Composable
fun TelaFinal(score: Int, onBackToStart: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Fundo com imagem
        Image(
            painter = painterResource(id = R.drawable.background_image),
            contentDescription = "Fundo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Conteúdo principal
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Parabéns!",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = poppins,
                color = Color.White,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "Sua pontuação final foi:",
                fontSize = 20.sp,
                fontFamily = poppins,
                color = Color.White,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "$score pontos",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = poppins,
                color = Color.Yellow,
                modifier = Modifier.padding(bottom = 32.dp)
            )
            Button(
                onClick = { onBackToStart() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(Color.White)
            ) {
                Text(
                    text = "Voltar ao Início",
                    fontSize = 18.sp,
                    fontFamily = poppins,
                    color = Color.Black
                )
            }
        }
    }
}
