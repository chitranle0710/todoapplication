package com.example.todoapplication.di

import android.app.Application
import androidx.room.Room
import com.example.todoapplication.data.AppDatabase
import com.example.todoapplication.data.TaskDao
import com.example.todoapplication.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, Constant.database)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun resDao(db: AppDatabase): TaskDao {
        return db.taskDao()
    }
}