package com.example.todoapplication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapplication.base.BaseViewModel
import com.example.todoapplication.model.Task
import com.example.todoapplication.usecase.FetchTaskUseCase
import com.example.todoapplication.usecase.InsertTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val useCase: InsertTaskUseCase,
    private val fetchTaskUseCase: FetchTaskUseCase
) : BaseViewModel() {
    val taskDoneLiveData = MutableLiveData<List<Task>>()
    val isLoading = MutableLiveData<Boolean>()
    fun insertTask(task: Task) {
        localScope.launch {
            isLoading.postValue(true)
            useCase.insertTask(task)
            fetchData()
            isLoading.postValue(false)
        }
    }

    fun fetchData() {
        localScope.launch {
            isLoading.postValue(true)
            val result = fetchTaskUseCase.fetchTask()
            taskDoneLiveData.postValue(result)
            isLoading.postValue(false)
        }
    }
}