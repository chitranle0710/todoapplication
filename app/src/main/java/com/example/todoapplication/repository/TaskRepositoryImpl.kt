package com.example.todoapplication.repository

import com.example.todoapplication.data.TaskDao
import com.example.todoapplication.model.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepositoryImpl @Inject constructor(private val taskDao: TaskDao) : TaskRepository {
    override fun insertTask(task: Task) = taskDao.insertTask(task)

    override fun fetchTask(): List<Task> =
        taskDao.fetchTasks()
}