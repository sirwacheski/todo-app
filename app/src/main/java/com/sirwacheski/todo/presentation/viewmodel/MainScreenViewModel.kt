package com.sirwacheski.todo.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class TodoItem(
    var title: String,
    var isChecked: Boolean
)


class MainScreenViewModel : ViewModel() {
    var title by mutableStateOf("")
    var todoList by mutableStateOf<List<TodoItem>>(emptyList())

    fun addTodo() {
        if(title.isBlank()) {
            return
        }

        todoList = todoList + TodoItem(title, false)
        title = ""
    }

    fun toggleTodo(index: Int) {
        val item = todoList[index]
        val mutableList = todoList.toMutableList()

        mutableList[index] = item.copy(isChecked = !item.isChecked)
        todoList = mutableList
    }
}