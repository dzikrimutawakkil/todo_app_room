package com.example.todolistapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.databinding.TaskItemCellBinding
import com.example.todolistapp.model.TaskItem

class TaskItemAdaptor(
    private val taskItems: List<TaskItem>,
    private val clickListener: TaskItemClickListener
): RecyclerView.Adapter<TaskItemViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = TaskItemCellBinding.inflate(from, parent, false)
        return TaskItemViewHolder(parent.context, binding, clickListener)
    }

    override fun getItemCount(): Int = taskItems.size

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        holder.bindTaskItem(taskItems[position])
    }

}