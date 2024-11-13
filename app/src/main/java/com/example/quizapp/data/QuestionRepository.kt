package com.example.quizapp.data

import com.example.quizapp.R

object QuestionRepository {
    val questions = listOf(
        Question(
            text = "Qual linguagem é mais usada para desenvolvimento Android?",
            imageResId = R.drawable.sample_image1,
            options = listOf("Java", "Kotlin", "Swift", "Python"),
            answers = listOf(
                Answer("Java", false),
                Answer("Kotlin", true),
                Answer("Swift", false),
                Answer("Python", false)
            ),
            correctAnswerIndex = 1
        ),
        Question(
            text = "O que é uma função recursiva?",
            imageResId = R.drawable.recursiva,
            options = listOf("Uma função que chama a si mesma", "Uma função que não retorna valor", "Uma função que executa em paralelo", "Uma função que depende de outra função"),
            answers = listOf(
                Answer("Uma função que chama a si mesma", true),
                Answer("Uma função que não retorna valor", false),
                Answer("Uma função que executa em paralelo", false),
                Answer("Uma função que depende de outra função", false)
            ),
            correctAnswerIndex = 0
        ),
        Question(
            text = "Qual destas é uma linguagem de marcação?",
            imageResId = R.drawable.html,
            options = listOf("HTML", "JavaScript", "Python", "Ruby"),
            answers = listOf(
                Answer("HTML", true),
                Answer("JavaScript", false),
                Answer("Python", false),
                Answer("Ruby", false)
            ),
            correctAnswerIndex = 0
        ),
        Question(
            text = "O que significa a sigla SQL?",
            imageResId = R.drawable.sql,
            options = listOf("Structured Query Language", "System Query Language", "Standard Query List", "Simple Query Language"),
            answers = listOf(
                Answer("Structured Query Language", true),
                Answer("System Query Language", false),
                Answer("Standard Query List", false),
                Answer("Simple Query Language", false)
            ),
            correctAnswerIndex = 0
        ),
        Question(
            text = "Qual estrutura de dados utiliza o princípio LIFO?",
            imageResId = R.drawable.lifo,
            options = listOf("Fila", "Árvore", "Pilha", "Lista"),
            answers = listOf(
                Answer("Fila", false),
                Answer("Árvore", false),
                Answer("Pilha", true),
                Answer("Lista", false)
            ),
            correctAnswerIndex = 2
        ),
        Question(
            text = "Qual destes é um banco de dados não relacional?",
            imageResId = R.drawable.bancodedados,
            options = listOf("MySQL", "PostgreSQL", "MongoDB", "Oracle"),
            answers = listOf(
                Answer("MySQL", false),
                Answer("PostgreSQL", false),
                Answer("MongoDB", true),
                Answer("Oracle", false)
            ),
            correctAnswerIndex = 2
        ),
        Question(
            text = "Qual o principal uso da linguagem CSS?",
            imageResId = R.drawable.css,
            options = listOf("Estruturar o conteúdo da página", "Criar interatividade na página", "Estilizar o conteúdo da página", "Armazenar dados da página"),
            answers = listOf(
                Answer("Estruturar o conteúdo da página", false),
                Answer("Criar interatividade na página", false),
                Answer("Estilizar o conteúdo da página", true),
                Answer("Armazenar dados da página", false)
            ),
            correctAnswerIndex = 2
        ),
        Question(
            text = "Para que serve o comando 'git commit'?",
            imageResId = R.drawable.commit,
            options = listOf("Enviar alterações para o repositório remoto", "Registrar mudanças no repositório local", "Baixar atualizações do repositório remoto", "Reverter mudanças no repositório"),
            answers = listOf(
                Answer("Enviar alterações para o repositório remoto", false),
                Answer("Registrar mudanças no repositório local", true),
                Answer("Baixar atualizações do repositório remoto", false),
                Answer("Reverter mudanças no repositório", false)
            ),
            correctAnswerIndex = 1
        ),
        Question(
            text = "Qual das seguintes opções representa um protocolo de transferência de hipertexto?",
            imageResId = R.drawable.http,
            options = listOf("HTTP", "FTP", "SMTP", "POP3"),
            answers = listOf(
                Answer("HTTP", true),
                Answer("FTP", false),
                Answer("SMTP", false),
                Answer("POP3", false)
            ),
            correctAnswerIndex = 0
        ),
        Question(
            text = "Qual das linguagens a seguir é tipicamente interpretada?",
            imageResId = R.drawable.python,
            options = listOf("C", "Assembly", "Python", "C++"),
            answers = listOf(
                Answer("C", false),
                Answer("Assembly", false),
                Answer("Python", true),
                Answer("C++", false)
            ),
            correctAnswerIndex = 2
        )
    )
}