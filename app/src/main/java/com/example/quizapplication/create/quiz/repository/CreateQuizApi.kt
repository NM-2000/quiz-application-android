package com.example.quizapplication.create.quiz.repository

import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface CreateQuizApi {

    @POST("/quiz/create")
    fun createQuiz(
        @Query("category") category: String,
        @Query("numOfQuestions") numOfQuestions: Int,
        @Query("title") title: String
    ): Call<Void>

}