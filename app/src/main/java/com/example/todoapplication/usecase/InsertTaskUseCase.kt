package com.example.todoapplication.usecase

import com.example.todoapplication.model.Task

interface InsertTaskUseCase {
    suspend fun insertTask(task: Task)
}