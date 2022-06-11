package com.example.todoapplication.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapplication.MainActivity
import com.example.todoapplication.R
import com.example.todoapplication.base.BaseFragment
import com.example.todoapplication.databinding.FragmentTodoBinding
import com.example.todoapplication.model.Task
import com.example.todoapplication.ui.adapter.TaskAdapter
import com.example.todoapplication.viewModel.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoFragment : BaseFragment() {
    private val viewModel: TaskViewModel by viewModels()
    private var binding: FragmentTodoBinding? = null
    private var isComplete: Boolean = false
    private var adapter: TaskAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTodoBinding.inflate(layoutInflater)

        binding?.btSubmit?.setOnClickListener {
            insertTask()
        }
        initRecyclerView()
        registerObserver()
        Log.d("ToDoFragment", "ToDoFragment OnCreateView")
        return binding!!.root
    }

    override fun onStart() {
        super.onStart()
        Log.d("ToDoFragment", "ToDoFragment onStart")
    }

    private fun registerObserver() {
        viewModel.fetchData()
        viewModel.isLoading.observe(this) {
            progressBar(it)
        }
        viewModel.taskLiveData.observe(this) {
            adapter?.updateData(it.toMutableList())
        }
    }

    private fun initRecyclerView() {
        adapter = TaskAdapter(mutableListOf())
        binding?.rvTask?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding?.rvTask?.setHasFixedSize(true)
        binding?.rvTask?.adapter = adapter
    }

    private fun insertTask() {
        if (binding?.etTask?.text.toString().isEmpty()) {
            binding?.tvError?.isVisible = true
            binding?.tvError?.text = requireContext().resources.getString(R.string.error_empty)
            return
        }
        isComplete = when (binding?.rgTask?.checkedRadioButtonId) {
            binding?.rdCom?.id -> {
                true
            }
            else -> {
                false
            }
        }
        binding?.tvError?.isVisible = false
        viewModel.insertTask(Task(null, binding?.etTask?.text.toString(), isComplete))
    }
}