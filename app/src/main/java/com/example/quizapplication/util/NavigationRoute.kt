package com.example.quizapplication.util

sealed class NavigationRoute(val route: String) {

    data object HOME : NavigationRoute("/home")

    data object ADD_QUESTION : NavigationRoute("/add/question")

    data object CREATE_QUIZ : NavigationRoute("/create/quiz")

    data object START_QUIZ : NavigationRoute("/start/quiz")

}