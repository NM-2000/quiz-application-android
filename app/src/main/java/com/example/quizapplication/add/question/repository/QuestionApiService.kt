package com.example.quizapplication.add.question.repository

import android.util.Log
import com.example.quizapplication.ServiceBuilder
import com.example.quizapplication.add.question.data.QuestionDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class QuestionApiService @Inject constructor() {

    fun addQuestion(questionDto: QuestionDto, onResult: () -> Unit) {
        val retrofit = ServiceBuilder.buildService(QuestionApi::class.java)
        retrofit.addQuestion(questionDto).enqueue(
            object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful) {
                        onResult()
                        Log.e("Quiz_Log", "Question successfully created!")
                    } else {
                        Log.e("Quiz_Log", "Question creation response code: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Log.e("Quiz_Log", t.stackTraceToString())
                }
            }
        )
    }

}