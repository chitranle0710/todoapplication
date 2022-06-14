package com.example.todoapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapplication.R
import com.example.todoapplication.base.BaseFragment
import com.example.todoapplication.databinding.FragmentUpdateBinding
import com.example.todoapplication.ui.adapter.TaskAdapter
import com.example.todoapplication.viewModel.TaskViewModel

class UpdateFragment : BaseFragment() {
    private val viewModel: TaskViewModel by activityViewModels()

    private var binding: FragmentUpdateBinding? = null
    private var adapter: TaskAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUpdateBinding.inflate(layoutInflater)
        initRecyclerView()
        registerObserver()
        return binding!!.root
    }

    private fun registerObserver() {
        viewModel.taskDoneLiveData.observe(requireActivity()) { listTask ->
            val newList = listTask.filter { !it.isDone }
            adapter?.updateData(newList.toMutableList())
        }
        viewModel.isLoading.observe(requireActivity()) {
            loading(it)
        }
    }

    private fun initRecyclerView() {
        adapter = TaskAdapter(mutableListOf())
        binding?.rvTaskIncomplete?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding?.rvTaskIncomplete?.setHasFixedSize(true)
        binding?.rvTaskIncomplete?.adapter = adapter
    }
}