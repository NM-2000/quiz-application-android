package com.example.quizapplication.create.quiz.viewmodel

import androidx.lifecycle.ViewModel
import com.example.quizapplication.create.quiz.data.CreateQuizDto
import com.example.quizapplication.create.quiz.repository.CreateQuizApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CreateQuizViewModel @Inject constructor(
    private val createQuizApiService: CreateQuizApiService
) : ViewModel() {

    private val _category = MutableStateFlow("")
    val category: StateFlow<String> = _category

    private val _title = MutableStateFlow("")
    val title: StateFlow<String> = _title

    private val _numOfQuestions = MutableStateFlow("")
    val numOfQuestions: StateFlow<String> = _numOfQuestions

    private val _dismiss = MutableStateFlow(false)
    val dismiss: StateFlow<Boolean> = _dismiss

    fun onEditCategory(category: String) {
        _category.value = category
    }

    fun onEditTitle(title: String) {
        _title.value = title
    }

    fun onEditNumOfQuestions(num: String) {
        _numOfQuestions.value = num
    }

    fun createQuiz() {
        createQuizApiService.createQuiz(
            CreateQuizDto(
                _category.value,
                _title.value,
                _numOfQuestions.value.toIntOrNull() ?: 1
            )
        ) {
            _dismiss.value = true
        }
    }

}