package com.example.todoapplication.repository

import com.example.todoapplication.model.Task

interface TaskRepository {
    suspend fun insertTask(task: Task)
    suspend fun fetchTask(): List<Task>
    suspend fun updateStatus(task: Task)
}