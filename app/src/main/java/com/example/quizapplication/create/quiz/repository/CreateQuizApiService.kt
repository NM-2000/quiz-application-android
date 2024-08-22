package com.example.quizapplication.create.quiz.repository

import android.util.Log
import com.example.quizapplication.ServiceBuilder
import com.example.quizapplication.create.quiz.data.CreateQuizDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CreateQuizApiService @Inject constructor() {

    fun createQuiz(createQuizDto: CreateQuizDto, onResult: () -> Unit) {
        val retrofit = ServiceBuilder.buildService(CreateQuizApi::class.java)
        retrofit.createQuiz(
            createQuizDto.category,
            createQuizDto.numberOfQuestions,
            createQuizDto.title
        ).enqueue(
            object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful) {
                        onResult()
                        Log.e("Quiz_Log", "Quiz successfully created!")
                    } else {
                        Log.e("Quiz_Log", "Quiz creation response code: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Log.e("Quiz_Log", t.stackTraceToString())
                }
            }
        )
    }

}