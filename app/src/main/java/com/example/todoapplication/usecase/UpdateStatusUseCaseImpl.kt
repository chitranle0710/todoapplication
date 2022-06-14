package com.example.todoapplication.usecase

import com.example.todoapplication.model.Task
import com.example.todoapplication.repository.TaskRepositoryImpl
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UpdateStatusUseCaseImpl @Inject constructor(private val repositoryImpl: TaskRepositoryImpl) :
    UpdateStatusUseCase {
    override suspend fun updateStatus(task: Task) =
        repositoryImpl.updateStatus(task)
}