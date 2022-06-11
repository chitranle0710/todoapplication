package com.example.todoapplication.usecase

import com.example.todoapplication.model.Task

interface InsertTaskUseCase {
    fun insertTask(task: Task)
}