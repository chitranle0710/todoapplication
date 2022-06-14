package com.example.todoapplication.usecase

import com.example.todoapplication.model.Task

interface UpdateStatusUseCase {
    suspend fun updateStatus(task: Task)
}