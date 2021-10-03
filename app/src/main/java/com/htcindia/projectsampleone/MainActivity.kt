package com.htcindia.projectsampleone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.htcindia.projectsampleone.adapter.RickMortyPagedAdapter
import com.htcindia.projectsampleone.databinding.ActivityMainBinding
import com.htcindia.projectsampleone.viewmodel.RickMortyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: RickMortyViewModel by viewModels()
    private lateinit var mAdapter: RickMortyPagedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRv()
        loadRv()
    }

    private fun loadRv() {
        lifecycleScope.launch{
            viewModel.listData.collect { pagingData ->
                mAdapter.submitData(pagingData)
            }
        }
    }

    private fun setUpRv() {
        mAdapter = RickMortyPagedAdapter()
        binding.rclrView.apply {
            adapter = mAdapter
            setHasFixedSize(true)
        }
    }
}