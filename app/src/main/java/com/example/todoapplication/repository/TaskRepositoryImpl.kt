package com.example.todoapplication.repository

import com.example.todoapplication.data.TaskDao
import com.example.todoapplication.di.scope.IoDispatcher
import com.example.todoapplication.model.Task
import com.example.todoapplication.utils.Event
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepositoryImpl @Inject constructor(
    private val taskDao: TaskDao,
    @IoDispatcher val ioDispatcher: CoroutineDispatcher
) : TaskRepository {
    override suspend fun insertTask(task: Task) = withContext(ioDispatcher) {
        taskDao.insertTask(task)
    }

    override suspend fun fetchTask(): List<Task> =
        withContext(ioDispatcher) { return@withContext taskDao.fetchTasks() }

    override suspend fun updateStatus(task: Task) = withContext(ioDispatcher) {
        taskDao.updateStatus(task)
    }

}