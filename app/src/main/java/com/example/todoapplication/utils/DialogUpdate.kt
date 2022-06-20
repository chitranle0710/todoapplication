package com.example.todoapplication.utils

import android.app.Dialog
import android.content.Context
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.todoapplication.R
import com.example.todoapplication.databinding.LayoutDialogUpdateBinding

class DialogUpdate(context: Context) : Dialog(context, R.style.Theme_Dialog) {
    private var binding: LayoutDialogUpdateBinding? = null
    var onClickDialog: (isComplete: Boolean, nameTask: String) -> Unit = { _, _ -> }
    private var isComplete: Boolean = true

    init {
        initDialog()
    }

    private fun initDialog() {
        binding = LayoutDialogUpdateBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        setCanceledOnTouchOutside(true)
        window?.setLayout(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.MATCH_PARENT
        )
        doOnClick()
    }

    private fun doOnClick() {
        isComplete = when (binding?.rgTask?.checkedRadioButtonId) {
            binding?.rdCom?.id -> {
                true
            }
            else -> {
                false
            }
        }
        binding?.btSubmit?.setOnClickListener {
            onClickDialog.invoke(isComplete, binding?.etTask?.text.toString())
        }
    }
}