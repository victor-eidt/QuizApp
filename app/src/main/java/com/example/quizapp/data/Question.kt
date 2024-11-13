package com.example.quizapp.data

data class Question(
    val text: String,
    val imageResId: Int?,  // ID da imagem, ou null se não houver imagem
    val options: List<String>,
    val answers: List<Answer>,
    val correctAnswerIndex: Int // Índice da resposta correta dentro da lista de opções
)

data class Answer(
    val text: String, // Texto da resposta
    val isCorrect: Boolean // Indica se a resposta é correta
)