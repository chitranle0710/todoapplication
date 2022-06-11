package com.example.todoapplication.di

import com.example.todoapplication.repository.TaskRepository
import com.example.todoapplication.repository.TaskRepositoryImpl
import com.example.todoapplication.usecase.FetchTaskUseCase
import com.example.todoapplication.usecase.FetchTaskUseCaseImpl
import com.example.todoapplication.usecase.InsertTaskUseCase
import com.example.todoapplication.usecase.InsertTaskUseCaseImpl
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
}