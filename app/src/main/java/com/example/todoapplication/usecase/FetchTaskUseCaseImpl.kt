package com.example.todoapplication.usecase

import com.example.todoapplication.model.Task
import com.example.todoapplication.repository.TaskRepositoryImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FetchTaskUseCaseImpl @Inject constructor(private val repository: TaskRepositoryImpl) :
    FetchTaskUseCase {
    override fun fetchTask(): List<Task> = repository.fetchTask()
}