package com.example.todolistapp

import android.content.Context
import android.content.LocusId
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.databinding.FragmentNewTaskSheetBinding
import com.example.todolistapp.databinding.TaskItemCellBinding
import com.example.todolistapp.model.TaskItem
import java.time.format.DateTimeFormatter

class TaskItemViewHolder(
    private val context: Context,
    private val binding: TaskItemCellBinding,
    private val clickListener: TaskItemClickListener
    ): RecyclerView.ViewHolder(binding.root) {
        private val timeFormat = DateTimeFormatter.ofPattern("HH:mm")
        fun bindTaskItem(taskItem: TaskItem){
            binding.name.text = taskItem.name

            if (taskItem.isCompleted()){
                binding.name.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                binding.dueTime.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            }

            binding.btnComplete.setImageResource(taskItem.imageResourrce())

            binding.btnComplete.setOnClickListener {
                clickListener.completeTaskItem(taskItem)
            }
            binding.cardItem.setOnClickListener {
                clickListener.editTaskItem(taskItem)
            }

            if (taskItem.dueTime() != null){
                binding.dueTime.text = timeFormat.format(taskItem.dueTime())
            } else  {
                binding.dueTime.text = ""
            }
        }
}