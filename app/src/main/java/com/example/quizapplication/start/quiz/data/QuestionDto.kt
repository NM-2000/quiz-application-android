package com.example.quizapplication.start.quiz.data

data class QuestionDto(
    val id: Int,
    val question: String,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String
)