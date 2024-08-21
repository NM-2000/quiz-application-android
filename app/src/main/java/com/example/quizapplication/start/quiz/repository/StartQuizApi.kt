package com.example.quizapplication.start.quiz.repository

import com.example.quizapplication.start.quiz.data.QuestionDto
import com.example.quizapplication.start.quiz.data.QuizSubmitDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface StartQuizApi {

    @GET("/quiz/{id}")
    fun fetchQuiz(@Path("id") id: Int): Call<List<QuestionDto>>

    @POST("/quiz/submit/{id}")
    fun submitQuiz(@Path("id") id: Int, @Body quizSubmitDto: List<QuizSubmitDto>): Call<Int>

}