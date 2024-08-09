package com.example.todolistapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.todolistapp.data.TaskItemRepository
import com.example.todolistapp.model.TaskItem
import kotlinx.coroutines.launch
import java.time.LocalDate

class TaskViewModel(private val repository: TaskItemRepository): ViewModel() {
    var taskItems: LiveData<List<TaskItem>> = repository.allTaskItem.asLiveData()

    fun addTaskItem(newTask: TaskItem) = viewModelScope.launch {
        repository.insertTaskItem(newTask)
    }

    fun updateTaskItem(taskItem: TaskItem) = viewModelScope.launch {
        repository.updateTaskItem(taskItem)
    }

    fun setCompleted(taskItem: TaskItem) = viewModelScope.launch {
        if (!taskItem.isCompleted()){
            taskItem.completeDateString = TaskItem.dateFormatter.format(LocalDate.now())
        }
        repository.updateTaskItem(taskItem)
    }
}