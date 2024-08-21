package com.example.quizapplication.add.question.data

data class QuestionDto(
    val question: String,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val answer: String,
    val category: String,
    val difficultyLevel: String,
)