package com.example.todolistapp

import android.app.Application
import com.example.todolistapp.data.TaskItemRepository
import com.example.todolistapp.data.local.TaskItemDatabase

class TodoApplication: Application(){
    private val database by lazy { TaskItemDatabase.getDatabase(this) }
    val repository by lazy { TaskItemRepository(database.taskItemDao()) }
}