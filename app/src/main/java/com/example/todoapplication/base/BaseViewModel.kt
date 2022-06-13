package com.example.todoapplication.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

open class BaseViewModel : ViewModel() {
    val localScope: CoroutineScope = CoroutineScope(Dispatchers.IO)
}