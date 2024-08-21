package com.example.quizapplication.start.quiz.repository

import android.util.Log
import com.example.quizapplication.ServiceBuilder
import com.example.quizapplication.start.quiz.data.QuestionDto
import com.example.quizapplication.start.quiz.data.QuizSubmitDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class StartQuizApiService @Inject constructor() {

    private val retrofit = ServiceBuilder.buildService(StartQuizApi::class.java)

    fun fetchQuiz(quizId: Int, onResult: (List<QuestionDto>?) -> Unit) {
        retrofit.fetchQuiz(quizId).enqueue(
            object : Callback<List<QuestionDto>> {
                override fun onResponse(
                    call: Call<List<QuestionDto>>,
                    response: Response<List<QuestionDto>>
                ) {
                    if (response.isSuccessful) {
                        onResult(response.body())
                    } else {
                        Log.e("Quiz_Log", "Quiz fetch response code: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<List<QuestionDto>>, t: Throwable) {
                    Log.e("Quiz_Log", t.stackTraceToString())
                }
            }
        )
    }

    fun submitQuiz(quizId: Int, quizSubmitDto: List<QuizSubmitDto>, onResult: (Int?) -> Unit) {
        retrofit.submitQuiz(quizId, quizSubmitDto).enqueue(
            object : Callback<Int> {
                override fun onResponse(call: Call<Int>, response: Response<Int>) {
                    if (response.isSuccessful) {
                        onResult(response.body())
                    } else {
                        Log.e("Quiz_Log", "Quiz submit response code: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<Int>, t: Throwable) {
                    Log.e("Quiz_Log", t.stackTraceToString())
                }
            }
        )
    }

}