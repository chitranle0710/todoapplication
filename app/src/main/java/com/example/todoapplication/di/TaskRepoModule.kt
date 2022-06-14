package com.example.todoapplication.di

import androidx.room.Update
import com.example.todoapplication.repository.TaskRepository
import com.example.todoapplication.repository.TaskRepositoryImpl
import com.example.todoapplication.usecase.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface TaskRepoModule {
    @Binds
    fun provideRestaurantRepository(taskRepositoryImpl: TaskRepositoryImpl): TaskRepository

    @Binds
    fun provideUseCaseInsertTask(useCaseImpl: InsertTaskUseCaseImpl): InsertTaskUseCase

    @Binds
    fun provideUseCaseFetchData(useCaseFetchImpl: FetchTaskUseCaseImpl): FetchTaskUseCase

    @Binds
    fun provideUpdateStatus(updateStatusUseCaseImpl: UpdateStatusUseCaseImpl): UpdateStatusUseCase
}