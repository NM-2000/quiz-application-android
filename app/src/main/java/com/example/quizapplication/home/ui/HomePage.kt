package com.example.quizapplication.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.quizapplication.R
import com.example.quizapplication.util.NavigationRoute

@Composable
fun HomePage(
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFFF6347)
            )
            .padding(
                horizontal = 32.dp,
                vertical = 80.dp
            )
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(id = R.string.quiz_application),
            style = TextStyle.Default.copy(
                color = Color.White,
                fontSize = 60.sp,
                lineHeight = 72.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold
            )
        )
        Column(
            modifier = Modifier.weight(1F),
            verticalArrangement = Arrangement.Center
        ) {
            OptionButton(text = stringResource(id = R.string.start_quiz)) {
                navController.navigate(NavigationRoute.START_QUIZ.route)
            }
            Spacer(modifier = Modifier.size(24.dp))
            OptionButton(text = stringResource(id = R.string.create_quiz)) {
                navController.navigate(NavigationRoute.CREATE_QUIZ.route)
            }
            Spacer(modifier = Modifier.size(24.dp))
            OptionButton(text = stringResource(id = R.string.add_question)) {
                navController.navigate(NavigationRoute.ADD_QUESTION.route)
            }
        }
    }
}

@Composable
fun OptionButton(
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable {
                onClick()
            }
            .padding(20.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = text,
            style = TextStyle.Default.copy(
                color = Color.Black,
                fontSize = 20.sp,
                lineHeight = 32.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}