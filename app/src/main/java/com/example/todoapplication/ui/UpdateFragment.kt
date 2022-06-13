package com.example.todoapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todoapplication.R
import com.example.todoapplication.base.BaseFragment
import com.example.todoapplication.databinding.FragmentUpdateBinding

class UpdateFragment : BaseFragment() {
    private var binding: FragmentUpdateBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUpdateBinding.inflate(layoutInflater)
        return binding!!.root
    }

}