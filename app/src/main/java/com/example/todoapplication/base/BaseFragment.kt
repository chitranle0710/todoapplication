package com.example.todoapplication.base

import androidx.fragment.app.Fragment
import com.example.todoapplication.utils.DialogLoading

abstract class BaseFragment : Fragment() {
    private val dialogLoading by lazy {
        DialogLoading(requireContext())
    }

    private fun progressBarView() {
        if (dialogLoading.isShowing) return
        dialogLoading.showDialog()
    }

    private fun dismissProgressBar() {
        if (dialogLoading.isShowing) dialogLoading.closeDialog()
    }

    fun loading(isShow: Boolean) {
        if (!isShow) progressBarView() else dismissProgressBar()
    }

}