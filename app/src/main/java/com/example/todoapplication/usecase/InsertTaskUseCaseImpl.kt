package com.example.todoapplication.usecase

import com.example.todoapplication.model.Task
import com.example.todoapplication.repository.TaskRepositoryImpl
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InsertTaskUseCaseImpl @Inject constructor(private val repositoryImpl: TaskRepositoryImpl) :
    InsertTaskUseCase {
    override fun insertTask(task: Task) = repositoryImpl.insertTask(task)
}