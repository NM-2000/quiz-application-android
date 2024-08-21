package com.example.quizapplication.add.question.repository

import com.example.quizapplication.add.question.data.QuestionDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface QuestionApi {

    @Headers("Content-Type: application/json")
    @POST("question/create")
    fun addQuestion(@Body questionDto: QuestionDto): Call<Void>

}