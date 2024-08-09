package com.example.todolistapp

import com.example.todolistapp.model.TaskItem

interface TaskItemClickListener {
    fun editTaskItem(taskItem: TaskItem)
    fun completeTaskItem(taskItem: TaskItem)
}