package com.example.quizapplication.start.quiz.viewmodel

import androidx.lifecycle.ViewModel
import com.example.quizapplication.start.quiz.data.QuizSubmitDto
import com.example.quizapplication.start.quiz.model.Question
import com.example.quizapplication.start.quiz.repository.StartQuizApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class StartQuizViewModel @Inject constructor(
    private val startQuizApiService: StartQuizApiService
) : ViewModel() {

    private val _loading = MutableStateFlow(true)
    val loading: StateFlow<Boolean> = _loading

    private val _questions = MutableStateFlow<List<Question>>(emptyList())
    val questions: StateFlow<List<Question>> = _questions

    private val _score = MutableStateFlow<Int?>(null)
    val score: StateFlow<Int?> = _score

    init {
        fetchQuiz()
    }

    private fun fetchQuiz() {
        startQuizApiService.fetchQuiz(
            quizId = 5
        ) { questions ->
            _questions.value = questions?.map {
                Question(
                    id = it.id,
                    question = it.question,
                    option1 = it.option1,
                    option2 = it.option2,
                    option3 = it.option3,
                    option4 = it.option4
                )
            } ?: emptyList()
            _loading.value = false
        }
    }

    fun onSelectOption(
        questionId: Int,
        answer: String
    ) {
        _questions.value = _questions.value.map { question ->
            if (question.id == questionId) {
                question.copy(
                    answer = answer
                )
            } else {
                question
            }
        }
    }

    fun onSubmitQuiz() {
        val quizSubmitDto = _questions.value.map {
            QuizSubmitDto(
                id = it.id,
                answer = it.answer ?: ""
            )
        }
        startQuizApiService.submitQuiz(
            quizId = 5,
            quizSubmitDto = quizSubmitDto
        ) { score ->
            score?.let {
                _score.value = it
            }
        }
    }

}