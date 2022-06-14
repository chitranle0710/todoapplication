package com.example.todoapplication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.todoapplication.base.BaseViewModel
import com.example.todoapplication.model.Task
import com.example.todoapplication.usecase.FetchTaskUseCase
import com.example.todoapplication.usecase.InsertTaskUseCase
import com.example.todoapplication.usecase.UpdateStatusUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val insertUseCase: InsertTaskUseCase,
    private val fetchTaskUseCase: FetchTaskUseCase,
    private val updateStatusUseCase: UpdateStatusUseCase,
) : BaseViewModel() {
    val taskDoneLiveData = MutableLiveData<List<Task>>()
    val isLoading = MutableLiveData(true)

    fun insertTask(task: Task) {
        viewModelScope.launch {
            isLoading.postValue(false)
            insertUseCase.insertTask(task)
            fetchData()
            isLoading.postValue(true)
        }
    }

    fun fetchData() {
        viewModelScope.launch {
            isLoading.postValue(false)
            val result = fetchTaskUseCase.fetchTask()
            taskDoneLiveData.postValue(result)
            isLoading.postValue(true)
        }
    }

    fun updateStatus(task: Task) {
        viewModelScope.launch {
            isLoading.postValue(false)
            updateStatusUseCase.updateStatus(task)
            isLoading.postValue(true)
            fetchData()
        }
    }

}