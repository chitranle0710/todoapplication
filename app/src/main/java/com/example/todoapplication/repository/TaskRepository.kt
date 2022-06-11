package com.example.todoapplication.repository

import com.example.todoapplication.model.Task

interface TaskRepository {
    fun insertTask(task: Task)
    fun fetchTask(): List<Task>
}