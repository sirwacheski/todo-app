package com.sirwacheski.todo.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sirwacheski.todo.presentation.viewmodel.MainScreenViewModel

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = MainScreenViewModel()
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = padding.calculateTopPadding() + 20.dp,
                    bottom = padding.calculateBottomPadding() + 20.dp,
                    start = 20.dp,
                    end = 20.dp
                )
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        singleLine = true,
                        value = viewModel.title,
                        shape = RoundedCornerShape(100),
                        placeholder = {
                            Text(text = "Enter a todo")
                        },
                        onValueChange = { text ->
                            viewModel.title = text
                        },
                        modifier = Modifier.
                            weight(1f)
                    )
                    Spacer(
                        modifier = Modifier.width(16.dp)
                    )
                    IconButton(
                        onClick = {
                            viewModel.addTodo()
                        },
                        colors = IconButtonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary,
                            disabledContainerColor = Color.Gray,
                            disabledContentColor = Color.Black
                        ),
                        modifier = Modifier
                            .size(55.dp)

                    ) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Add",
                            modifier = Modifier.size(27.dp)
                        )
                    }
                }
                Spacer(
                    modifier = Modifier.height(16.dp)
                )
                if(viewModel.todoList.isEmpty()) {
                    Column (
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Text(
                            text = "Empty List",
                            fontSize = 20.sp,
                            color = Color.Gray
                        )
                    }
                } else {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(20.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        itemsIndexed(viewModel.todoList) { index, item ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Checkbox(
                                    checked = item.isChecked,
                                    onCheckedChange = {
                                        viewModel.toggleTodo(index)
                                    },
                                    modifier = Modifier
                                        .size(24.dp)
                                )
                                Spacer(
                                    modifier = Modifier.width(12.dp)
                                )
                                Text(
                                    text = item.title,
                                    maxLines = 2,
                                    fontSize = 18.sp,
                                    modifier = Modifier.weight(1f),
                                    style = TextStyle(
                                        textDecoration = if (item.isChecked) TextDecoration.LineThrough else TextDecoration.None
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}