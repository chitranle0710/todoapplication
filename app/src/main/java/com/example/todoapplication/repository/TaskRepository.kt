package com.example.todoapplication.repository

import com.example.todoapplication.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun insertTask(task: Task)
    fun fetchTask(): List<Task>
}