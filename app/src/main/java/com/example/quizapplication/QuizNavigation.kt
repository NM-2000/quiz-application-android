package com.example.quizapplication

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quizapplication.add.question.ui.AddQuestionScreen
import com.example.quizapplication.add.question.viewmodel.AddQuestionScreenViewModel
import com.example.quizapplication.create.quiz.ui.CreateQuizScreen
import com.example.quizapplication.create.quiz.viewmodel.CreateQuizViewModel
import com.example.quizapplication.home.ui.HomePage
import com.example.quizapplication.start.quiz.ui.StartQuizScreen
import com.example.quizapplication.start.quiz.viewmodel.StartQuizViewModel
import com.example.quizapplication.util.NavigationRoute

@Composable fun QuizNavigationHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavigationRoute.HOME.route
    ) {
        composable(
            route = NavigationRoute.HOME.route
        ) {
            HomePage(
                navController = navController
            )
        }

        composable(
            route = NavigationRoute.ADD_QUESTION.route
        ) {
            val viewModel: AddQuestionScreenViewModel = hiltViewModel()
            AddQuestionScreen(viewModel)
        }

        composable(
            route = NavigationRoute.CREATE_QUIZ.route
        ) {
            val viewModel: CreateQuizViewModel = hiltViewModel()
            CreateQuizScreen(navHostController = navController, viewModel = viewModel)
        }

        composable(
            route = NavigationRoute.START_QUIZ.route
        ) {
            val viewModel: StartQuizViewModel = hiltViewModel()
            StartQuizScreen(navHostController = navController, viewModel = viewModel)
        }
    }
}