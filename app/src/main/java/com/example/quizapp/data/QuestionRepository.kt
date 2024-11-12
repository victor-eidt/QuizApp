package com.example.quizapp.data

import com.example.quizapp.R

object QuestionRepository {
    val questions = listOf(
        Question(
            text = "Qual linguagem é mais usada para desenvolvimento Android?",
            imageResId = R.drawable.sample_image1,  // Substitua por uma imagem válida ou remova
            options = listOf("Java", "Kotlin", "Swift", "Python"),
            correctAnswerIndex = 1 // kotlin
        ),
        Question(
            text = "O que é uma função recursiva?",
            imageResId = R.drawable.recursiva,
            options = listOf("Uma função que chama a si mesma", "Uma função que não retorna valor", "Uma função que executa em paralelo", "Uma função que depende de outra função"),
            correctAnswerIndex = 0 // uma função que chama a si mesma
        ),
        Question(
            text = "Qual destas é uma linguagem de marcação?",
            imageResId = R.drawable.html,
            options = listOf("HTML", "JavaScript", "Python", "Ruby"),
            correctAnswerIndex = 0 // html
        ),
        Question(
            text = "O que significa a sigla SQL?",
            imageResId = R.drawable.sql,
            options = listOf("Structured Query Language", "System Query Language", "Standard Query List", "Simple Query Language"),
            correctAnswerIndex = 0 // structured query language
        ),
        Question(
            text = "Qual estrutura de dados utiliza o princípio LIFO?",
            imageResId = R.drawable.lifo,
            options = listOf("Fila", "Árvore", "Pilha", "Lista"),
            correctAnswerIndex = 2 // pilha
        ),
        Question(
            text = "Qual destes é um banco de dados não relacional?",
            imageResId = R.drawable.bancodedados,
            options = listOf("MySQL", "PostgreSQL", "MongoDB", "Oracle"),
            correctAnswerIndex = 2 // mongoDB
        ),
        Question(
            text = "Qual o principal uso da linguagem CSS?",
            imageResId = R.drawable.css,
            options = listOf("Estruturar o conteúdo da página", "Criar interatividade na página", "Estilizar o conteúdo da página", "Armazenar dados da página"),
            correctAnswerIndex = 2 // estilizar o conteúdo da página
        ),
        Question(
            text = "Para que serve o comando 'git commit'?",
            imageResId = R.drawable.commit,
            options = listOf("Enviar alterações para o repositório remoto", "Registrar mudanças no repositório local", "Baixar atualizações do repositório remoto", "Reverter mudanças no repositório"),
            correctAnswerIndex = 1 // registrar mudancas...
        ),
        Question(
            text = "Qual das seguintes opções representa um protocolo de transferência de hipertexto?",
            imageResId = R.drawable.http,
            options = listOf("HTTP", "FTP", "SMTP", "POP3"),
            correctAnswerIndex = 0 // HTTP
        ),
        Question(
            text = "Qual das linguagens a seguir é tipicamente interpretada?",
            imageResId = R.drawable.python,
            options = listOf("C", "Assembly", "Python", "C++"),
            correctAnswerIndex = 2 // Python
        )
    )
}
