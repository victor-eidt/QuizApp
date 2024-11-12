package com.example.quizapp.data

data class Question(
    val text: String,
    val imageResId: Int?,  // ID da imagem, ou null se não houver imagem
    val options: List<String>,
    val correctAnswerIndex: Int // Índice da resposta correta dentro da lista de opções
)