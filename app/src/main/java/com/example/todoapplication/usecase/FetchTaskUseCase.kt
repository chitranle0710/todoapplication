package com.example.todoapplication.usecase

import com.example.todoapplication.model.Task

interface FetchTaskUseCase {
    suspend fun fetchTask(): List<Task>
}