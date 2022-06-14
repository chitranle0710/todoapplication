package com.example.todoapplication.data

import androidx.room.*
import com.example.todoapplication.model.Task

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(vararg task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("delete from task_table")
    suspend fun deleteAll()

    @Update
    suspend fun updateStatus(task: Task)

    @Query("select * from task_table")
    suspend fun fetchTasks(): List<Task>

}