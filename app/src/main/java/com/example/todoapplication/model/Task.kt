package com.example.todoapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val taskName: String,
    val isDone: Boolean
)