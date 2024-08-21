package com.example.quizapplication.create.quiz.data

data class CreateQuizDto(
    val category: String,
    val title: String,
    val numberOfQuestions: Int
)