package com.example.todoapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplication.R
import com.example.todoapplication.databinding.ItemTaskBinding
import com.example.todoapplication.model.Task

class TaskAdapter(private var listTask: MutableList<Task>) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    private var onClick: (task: Task) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun updateData(data: MutableList<Task>?) {
        data ?: return
        if (this.listTask == data) {
            return
        }
        val diffCallback = TaskDiff(listTask, data)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        diffResult.dispatchUpdatesTo(this)
        listTask.clear()
        listTask.addAll(data)
    }

    override fun getItemCount(): Int = listTask.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(listTask[position], onClick)
    }

    inner class TaskViewHolder(private val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task, onClick: (task: Task) -> Unit) {
            binding.tvNameTask.text = task.taskName
            if (task.isDone) binding.ivStatus.setImageResource(R.drawable.complete) else binding.ivStatus.setImageResource(
                R.drawable.incomplete
            )
            binding.root.setOnClickListener {
                onClick.invoke(task)
            }
        }
    }

}



