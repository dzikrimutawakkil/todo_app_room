package com.example.todolistapp.model

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todolistapp.R
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.UUID

@Entity(tableName = "task_item_table")
class TaskItem (
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "desc") var desc: String,
    @ColumnInfo(name = "dueTimeString") var dueTimeString: String?,
    @ColumnInfo(name = "completeDateString") var completeDateString: String?,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
){
    fun isCompleted() = completeDate() != null
    fun imageResourrce(): Int = if (isCompleted()) R.drawable.checked_icon else R.drawable.unchecked_icon
    fun completeDate(): LocalDate? = if(completeDateString == null) null else LocalDate.parse(completeDateString, dateFormatter)
    fun dueTime(): LocalTime? = if(dueTimeString == null) null else LocalTime.parse(dueTimeString, timeFormatter)

    companion object{
        val timeFormatter: DateTimeFormatter = DateTimeFormatter.ISO_TIME
        val dateFormatter: DateTimeFormatter = DateTimeFormatter.ISO_DATE
    }
}