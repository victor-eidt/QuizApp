package com.example.quizapp.ui.theme.screens

import android.media.MediaPlayer
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.data.Question
import com.example.quizapp.data.Score
import com.example.quizapp.R
import com.example.quizapp.ui.theme.poppins
import kotlinx.coroutines.delay

@Composable
fun QuestionView(
    question: Question,
    score: Score,
    onAnswerSelected: (isCorrect: Boolean) -> Unit,
    onQuizEnd: () -> Unit
) {
    val context = LocalContext.current
    var selectedOptionIndex by remember { mutableStateOf<Int?>(null) }
    var buttonColors by remember { mutableStateOf(List(question.answers.size) { Color.White }) }
    var isCorrectAnswer by remember { mutableStateOf(false) }
    var showNextQuestion by remember { mutableStateOf(false) }
    var shuffledAnswers by remember { mutableStateOf(question.answers.shuffled()) }

    if (showNextQuestion) {
        selectedOptionIndex = null
        buttonColors = List(question.answers.size) { Color.White }
        showNextQuestion = false
    }

    Crossfade(
        targetState = question,
        animationSpec = tween(durationMillis = 600)
    ) { currentQuestion ->
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.background_image),
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
                Text(
                    text = currentQuestion.text,
                    fontSize = 20.sp,
                    color = Color.White,
                    fontFamily = poppins,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 32.dp),
                    textAlign = TextAlign.Center
                )

                currentQuestion.imageResId?.let {
                    Image(
                        painter = painterResource(id = it),
                        contentDescription = null,
                        modifier = Modifier
                            .size(150.dp)
                            .padding(bottom = 16.dp),
                        contentScale = ContentScale.Fit
                    )
                }

                shuffledAnswers.forEachIndexed { index, answer ->
                    Button(
                        onClick = {
                            if (selectedOptionIndex == null) {
                                selectedOptionIndex = index
                                isCorrectAnswer = answer.isCorrect
                                buttonColors = buttonColors.toMutableList().apply {
                                    this[index] = if (isCorrectAnswer) Color.Green else Color.Red
                                }

                                if (isCorrectAnswer) {
                                    val mediaPlayer = MediaPlayer.create(context, R.raw.correct_sound)
                                    mediaPlayer.start()
                                    mediaPlayer.setOnCompletionListener { it.release() }
                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = buttonColors[index]
                        )
                    ) {
                        Text(
                            text = answer.text,
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontFamily = poppins
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Score: ${score.totalScore}",
                    fontSize = 18.sp,
                    color = Color.White,
                    fontFamily = poppins,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }
    }

    LaunchedEffect(selectedOptionIndex) {
        if (selectedOptionIndex != null) {
            delay(1000)
            if (isCorrectAnswer) {
                onAnswerSelected(true)
                showNextQuestion = true
            } else {
                onQuizEnd()
            }
        }
    }
}
