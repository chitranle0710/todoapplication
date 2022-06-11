package com.example.todoapplication.data

import androidx.room.*
import com.example.todoapplication.model.Task

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(vararg task: Task)

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Query("delete from task_table")
    fun deleteAll()

    @Query("select * from task_table")
    fun fetchTasks(): List<Task>

}