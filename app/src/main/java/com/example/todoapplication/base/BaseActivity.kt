package com.example.todoapplication.base

import androidx.appcompat.app.AppCompatActivity
import com.example.todoapplication.DialogLoading

abstract class BaseActivity : AppCompatActivity() {
    private val dialogLoading by lazy {
        DialogLoading(this)
    }

    private fun progressBarView() {
        if (dialogLoading.isShowing) return
        dialogLoading.showDialog()
    }

    private fun dismissProgressBar() {
        if (dialogLoading.isShowing) dialogLoading.closeDialog()
    }

    fun progressBar(isShow: Boolean) {
        if (isShow) progressBarView() else dismissProgressBar()
    }
}