package com.example.todoapplication.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapplication.R
import com.example.todoapplication.base.BaseFragment
import com.example.todoapplication.databinding.FragmentTodoBinding
import com.example.todoapplication.model.Task
import com.example.todoapplication.ui.adapter.TaskAdapter
import com.example.todoapplication.utils.DialogUpdate
import com.example.todoapplication.viewModel.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoFragment : BaseFragment() {
    private val viewModel: TaskViewModel by activityViewModels()
    private var binding: FragmentTodoBinding? = null
    private var isComplete: Boolean = false
    private var adapter: TaskAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTodoBinding.inflate(layoutInflater)

        initRecyclerView()
        registerObserver()
        onClick()

        return binding!!.root
    }

    private fun onClick() {
        binding?.btSubmit?.setOnClickListener {
            doOnSubmit()
        }
    }

    private fun registerObserver() {
        with(viewModel) {
            taskDoneLiveData.observe(requireActivity()) { listTask ->
                val newList = listTask.filter { it.isDone }
                adapter?.updateData(newList.toMutableList())
            }
            isLoading.observe(requireActivity()) {
                loading(it)
            }
        }
    }

    private fun initRecyclerView() {
        adapter = TaskAdapter(mutableListOf())
        binding?.rvTask?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding?.rvTask?.setHasFixedSize(true)
        binding?.rvTask?.adapter = adapter
        adapter?.onClick = { task ->
            binding?.btSubmit?.text = getString(R.string.update)
            initDialog(task)
        }
    }

    private fun initDialog(task: Task) {
        val dialog = DialogUpdate(requireContext())
        dialog.onClickDialog = { isComplete, nameTask ->
            viewModel.updateStatus(
                Task(
                    id = task.id,
                    nameTask,
                    isComplete
                )
            )
        }
        dialog.show()
    }

    private fun doOnSubmit() {
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
        binding?.etTask?.setText("")
    }

}