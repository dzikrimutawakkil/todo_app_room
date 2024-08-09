package com.example.todolistapp.data

import androidx.annotation.WorkerThread
import com.example.todolistapp.data.local.TaskItemDao
import com.example.todolistapp.model.TaskItem
import kotlinx.coroutines.flow.Flow

//ADAPTOR
class TaskItemRepository (private val taskItemDao: TaskItemDao){
    val allTaskItem: Flow<List<TaskItem>> = taskItemDao.allTaskItem()

    @WorkerThread
    suspend fun insertTaskItem(taskItem: TaskItem){
        taskItemDao.insertTaskItem(taskItem)
    }

    @WorkerThread
    suspend fun updateTaskItem(taskItem: TaskItem){
        taskItemDao.insertTaskItem(taskItem)
    }

    @WorkerThread
    suspend fun deleteTaskItem(taskItem: TaskItem){
        taskItemDao.insertTaskItem(taskItem)
    }
}