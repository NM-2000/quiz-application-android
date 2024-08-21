package com.example.quizapplication.add.question.viewmodel

import androidx.lifecycle.ViewModel
import com.example.quizapplication.add.question.data.QuestionDto
import com.example.quizapplication.add.question.repository.QuestionApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AddQuestionScreenViewModel @Inject constructor(
    val questionApiService: QuestionApiService
) : ViewModel() {

    private val _selectedOption = MutableStateFlow(1)
    val selectedOption: StateFlow<Int> = _selectedOption

    private val _question = MutableStateFlow("")
    val question: StateFlow<String> = _question

    private val _option1 = MutableStateFlow("")
    val option1: StateFlow<String> = _option1

    private val _option2 = MutableStateFlow("")
    val option2: StateFlow<String> = _option2

    private val _option3 = MutableStateFlow("")
    val option3: StateFlow<String> = _option3

    private val _option4 = MutableStateFlow("")
    val option4: StateFlow<String> = _option4

    fun onSelectOption(option: Int) {
        _selectedOption.value = option
    }

    fun onTypingQuestion(question: String) {
        _question.value = question
    }

    fun onTypingOption(option: String, optionNumber: Int) {
        when (optionNumber) {
            1 -> {
                _option1.value = option
            }
            2 -> {
                _option2.value = option
            }
            3 -> {
                _option3.value = option
            }
            4 -> {
                _option4.value = option
            }
        }
    }

    fun onSubmitQuestion() {
        questionApiService.addQuestion(
            QuestionDto(
                question = _question.value,
                option1 = _option1.value,
                option2 = _option2.value,
                option3 = _option3.value,
                option4 = _option4.value,
                answer = fetchAnswer(),
                category = "GK",
                difficultyLevel = "Easy"
            )
        )
    }

    private fun fetchAnswer(): String {
        return when (_selectedOption.value) {
            1 -> _option1.value
            2 -> _option2.value
            3 -> _option3.value
            else -> _option4.value
        }
    }

}
