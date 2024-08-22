package com.example.quizapplication.create.quiz.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.quizapplication.create.quiz.viewmodel.CreateQuizViewModel

@Composable
fun CreateQuizScreen(
    navHostController: NavHostController,
    viewModel: CreateQuizViewModel
) {
    val category by viewModel.category.collectAsStateWithLifecycle()
    val title by viewModel.title.collectAsStateWithLifecycle()
    val numOfQuestions by viewModel.numOfQuestions.collectAsStateWithLifecycle()
    val dismiss by viewModel.dismiss.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = dismiss) {
        if (dismiss) {
            navHostController.navigateUp()
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFFF6347)
            )
            .padding(
                horizontal = 32.dp,
                vertical = 80.dp
            ),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Please enter the category below:",
            style = TextStyle.Default.copy(
                color = Color.White,
                lineHeight = 20.sp,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.size(16.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = category,
            onValueChange = {
                viewModel.onEditCategory(it)
            },
            placeholder = {
                Text(
                    text = "Category",
                    style = TextStyle.Default.copy(
                        color = Color.Black,
                        letterSpacing = 0.6.sp
                    )
                )
            },
            maxLines = 1,
            colors = TextFieldDefaults.colors().copy(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.DarkGray,
                unfocusedIndicatorColor = Color.Gray
            )
        )
        Spacer(modifier = Modifier.size(32.dp))
        Text(
            text = "Please enter the title below:",
            style = TextStyle.Default.copy(
                color = Color.White,
                lineHeight = 20.sp,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.size(16.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = title,
            onValueChange = {
                viewModel.onEditTitle(it)
            },
            placeholder = {
                Text(
                    text = "Title",
                    style = TextStyle.Default.copy(
                        color = Color.Black,
                        letterSpacing = 0.6.sp
                    )
                )
            },
            maxLines = 1,
            colors = TextFieldDefaults.colors().copy(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.DarkGray,
                unfocusedIndicatorColor = Color.Gray
            )
        )
        Spacer(modifier = Modifier.size(32.dp))
        Text(
            text = "Please enter the number of questions below:",
            style = TextStyle.Default.copy(
                color = Color.White,
                lineHeight = 20.sp,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.size(16.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = TextFieldValue(
                text = numOfQuestions.toString(),
                selection = TextRange(numOfQuestions.toString().length)
            ),
            onValueChange = {
                viewModel.onEditNumOfQuestions(it.text)
            },
            placeholder = {
                Text(
                    text = "How many questions?",
                    style = TextStyle.Default.copy(
                        color = Color.Black,
                        letterSpacing = 0.6.sp
                    )
                )
            },
            maxLines = 1,
            colors = TextFieldDefaults.colors().copy(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.DarkGray,
                unfocusedIndicatorColor = Color.Gray
            )
        )
        Spacer(modifier = Modifier.size(32.dp))
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .background(
                    color = Color.DarkGray,
                    shape = RoundedCornerShape(4.dp)
                )
                .clickable {
                    viewModel.createQuiz()
                }
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
        ) {
            Text(
                text = "Done",
                style = TextStyle.Default.copy(
                    color = Color.White,
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}