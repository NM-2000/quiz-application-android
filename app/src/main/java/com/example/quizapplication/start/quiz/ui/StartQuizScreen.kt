package com.example.quizapplication.start.quiz.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.quizapplication.start.quiz.model.Question
import com.example.quizapplication.start.quiz.viewmodel.StartQuizViewModel

@Composable
fun StartQuizScreen(
    navHostController: NavHostController,
    viewModel: StartQuizViewModel
) {
    val loading by viewModel.loading.collectAsStateWithLifecycle()
    val questions by viewModel.questions.collectAsStateWithLifecycle()
    val score by viewModel.score.collectAsStateWithLifecycle()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFFF6347)
            )
            .padding(vertical = 80.dp),
        contentAlignment = Alignment.Center
    ) {
        if (loading) {
            CircularProgressIndicator(
                color = Color.White
            )
        }
        else if (score != null) {
            Text(
                text = "Congratulations! You answered $score questions correctly!",
                style = TextStyle.Default.copy(
                    color = Color.White,
                    fontSize = 36.sp,
                    lineHeight = 64.sp,
                    textAlign = TextAlign.Center
                )
            )
        }
        else {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(
                    horizontal = 24.dp
                )
            ) {
                itemsIndexed(questions) { index: Int, question: Question ->
                    QuestionCard(
                        question = question,
                        onSelectOption = viewModel::onSelectOption
                    )
                    if (index < questions.size - 1) {
                        Spacer(modifier = Modifier.size(24.dp))
                    }
                }
            }
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .background(
                        color = Color.DarkGray,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clickable { viewModel.onSubmitQuiz() }
                    .padding(
                        horizontal = 16.dp,
                        vertical = 12.dp
                    )
            ) {
                Text(
                    text = "Submit",
                    style = TextStyle.Default.copy(
                        color = Color.White,
                        fontSize = 20.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

@Composable
fun QuestionCard(
    modifier: Modifier = Modifier,
    question: Question,
    onSelectOption: (Int, String) -> Unit
) {
    Card(
        shape = RoundedCornerShape(32.dp),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier
                .height(500.dp)
                .width(300.dp)
                .background(
                    color = Color.Transparent,
                    shape = RoundedCornerShape(32.dp)
                )
                .padding(
                    horizontal = 24.dp,
                    vertical = 56.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = question.question,
                style = TextStyle.Default.copy(
                    color = Color.DarkGray,
                    fontSize = 20.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Spacer(modifier = Modifier.size(24.dp))
            listOf(
                question.option1,
                question.option2,
                question.option3,
                question.option4
            ).forEachIndexed { index, option ->
                OptionWidget(
                    questionId = question.id,
                    option = option,
                    selected = question.answer == option,
                    onSelectOption = onSelectOption
                )
                if (index < 3) {
                    Spacer(modifier = Modifier.size(16.dp))
                }
            }
        }
    }
}

@Composable
fun OptionWidget(
    questionId: Int,
    option: String,
    selected: Boolean,
    onSelectOption: (Int, String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = if (selected) Color.Green else Color.White,
                shape = RoundedCornerShape(8.dp)
            )
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                onSelectOption(questionId, option)
            }
            .padding(
                horizontal = 16.dp,
                vertical = 16.dp
            )
    ) {
        Text(
            text = option,
            style = TextStyle.Default.copy(
                color = Color.Black,
                fontSize = 16.sp,
                lineHeight = 20.sp
            )
        )
    }
}