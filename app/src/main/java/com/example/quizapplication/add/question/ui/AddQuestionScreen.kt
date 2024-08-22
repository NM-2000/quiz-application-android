package com.example.quizapplication.add.question.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.quizapplication.add.question.viewmodel.AddQuestionScreenViewModel

@Composable
fun AddQuestionScreen(
    navHostController: NavHostController,
    viewModel: AddQuestionScreenViewModel
) {
    val question by viewModel.question.collectAsStateWithLifecycle()
    val category by viewModel.category.collectAsStateWithLifecycle()
    val option1 by viewModel.option1.collectAsStateWithLifecycle()
    val option2 by viewModel.option2.collectAsStateWithLifecycle()
    val option3 by viewModel.option3.collectAsStateWithLifecycle()
    val option4 by viewModel.option4.collectAsStateWithLifecycle()
    val selectedOption by viewModel.selectedOption.collectAsStateWithLifecycle()
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
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = question,
            onValueChange = viewModel::onTypingQuestion,
            placeholder = {
                Text(
                    text = "Type the Question ...",
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
                unfocusedIndicatorColor = Color.Gray,
                cursorColor = Color.DarkGray
            )
        )
        Spacer(modifier = Modifier.size(32.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = category,
            onValueChange = viewModel::onTypingCategory,
            placeholder = {
                Text(
                    text = "Type the Category ...",
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
                unfocusedIndicatorColor = Color.Gray,
                cursorColor = Color.DarkGray
            )
        )
        Spacer(modifier = Modifier.size(32.dp))
        Text(
            text = "Please enter the options below:",
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
            value = option1,
            onValueChange = {
                viewModel.onTypingOption(it, 1)
            },
            placeholder = {
                Text(
                    text = "1st Option",
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
        Spacer(modifier = Modifier.size(16.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = option2,
            onValueChange = {
                viewModel.onTypingOption(it, 2)
            },
            placeholder = {
                Text(
                    text = "2nd Option",
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
        Spacer(modifier = Modifier.size(16.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = option3,
            onValueChange = {
                viewModel.onTypingOption(it, 3)
            },
            placeholder = {
                Text(
                    text = "3rd Option",
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
        Spacer(modifier = Modifier.size(16.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = option4,
            onValueChange = {
                viewModel.onTypingOption(it, 4)
            },
            placeholder = {
                Text(
                    text = "4th Option",
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
            text = "Select the right option below:",
            style = TextStyle.Default.copy(
                color = Color.White,
                lineHeight = 20.sp,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.size(16.dp))
        OptionSelector(
            selectedOption = selectedOption,
            onSelectOption = viewModel::onSelectOption
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
                    viewModel.onSubmitQuestion()
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

@Composable
fun OptionSelector(
    selectedOption: Int,
    onSelectOption: (Int) -> Unit
) {
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        listOf(1, 2, 3, 4).forEachIndexed { index, i ->
            Box(
                modifier = Modifier
                    .background(
                        color = if (i == selectedOption)
                            Color.Green
                        else Color.White,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .clickable { onSelectOption(i) }
                    .padding(
                        vertical = 8.dp,
                        horizontal = 16.dp
                    )
            ) {
                Text(
                    text = i.toString(),
                    style = TextStyle.Default.copy(
                        color = Color.Black,
                        fontWeight = if (i == selectedOption)
                            FontWeight.Bold
                        else FontWeight.Normal
                    )
                )
            }
        }
    }
}