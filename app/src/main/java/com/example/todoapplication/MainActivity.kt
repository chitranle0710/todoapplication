package com.example.todoapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.example.todoapplication.base.BaseActivity
import com.example.todoapplication.databinding.ActivityMainBinding
import com.example.todoapplication.ui.TodoFragment
import com.example.todoapplication.viewModel.TaskViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private val viewModel: TaskViewModel by viewModels()

    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initNavigation()
        registerObserver()
    }

    private fun initNavigation() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        viewBinding.bottomNavigation.setupWithNavController(navController)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.todoFragment2, R.id.updateFragment2))
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    private fun registerObserver() {
        viewModel.fetchData()
        viewModel.isLoading.observe(this) {
            progressBar(it)
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }
}