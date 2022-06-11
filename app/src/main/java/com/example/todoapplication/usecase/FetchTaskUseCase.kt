package com.example.todoapplication.usecase

import com.example.todoapplication.model.Task

interface FetchTaskUseCase {
    fun fetchTask(): List<Task>
}