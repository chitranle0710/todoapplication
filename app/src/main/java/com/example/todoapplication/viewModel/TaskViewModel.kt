package com.example.todoapplication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapplication.model.Task
import com.example.todoapplication.usecase.FetchTaskUseCase
import com.example.todoapplication.usecase.InsertTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val useCase: InsertTaskUseCase,
    private val fetchTaskUseCase: FetchTaskUseCase
) : ViewModel() {
    val taskLiveData = MutableLiveData<List<Task>>()
    val isLoading = MutableLiveData<Boolean>()
    fun insertTask(task: Task) {
        CoroutineScope(Dispatchers.IO).launch {
            isLoading.postValue(true)
            useCase.insertTask(task)
            fetchData()
            isLoading.postValue(false)
        }
    }

    fun fetchData() {
        CoroutineScope(Dispatchers.IO).launch {
            isLoading.postValue(true)
            val result = fetchTaskUseCase.fetchTask()
            taskLiveData.postValue(result)
            isLoading.postValue(false)
        }
    }
}