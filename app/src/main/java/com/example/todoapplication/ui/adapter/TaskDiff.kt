package com.example.todoapplication.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.todoapplication.model.Task

class TaskDiff(
    private val oldList: MutableList<Task>,
    private val newList: MutableList<Task>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].taskName === newList[newItemPosition].taskName
    }
}