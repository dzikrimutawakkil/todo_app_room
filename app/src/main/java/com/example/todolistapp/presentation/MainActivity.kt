package com.example.todolistapp.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolistapp.NewTaskSheet
import com.example.todolistapp.TaskItemAdaptor
import com.example.todolistapp.TaskItemClickListener
import com.example.todolistapp.data.TaskItemModelFactory
import com.example.todolistapp.TodoApplication
import com.example.todolistapp.databinding.ActivityMainBinding
import com.example.todolistapp.model.TaskItem

class MainActivity : AppCompatActivity(), TaskItemClickListener {

    private lateinit var binding: ActivityMainBinding

    private val taskViewModel: TaskViewModel by viewModels {
        TaskItemModelFactory((application as TodoApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.newTaskButton.setOnClickListener {
            NewTaskSheet(null).show(supportFragmentManager, "newTaskTag")
        }
        setRecycleView()
    }

    private fun setRecycleView() {
        val mainActivity = this
        taskViewModel.taskItems.observe(this){
            binding.rvTodo.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = TaskItemAdaptor(it, mainActivity)
            }
        }
    }

    override fun editTaskItem(taskItem: TaskItem) {
        NewTaskSheet(taskItem).show(supportFragmentManager, "newTaskTag")
    }

    override fun completeTaskItem(taskItem: TaskItem) {
        taskViewModel.setCompleted(taskItem)
    }
}