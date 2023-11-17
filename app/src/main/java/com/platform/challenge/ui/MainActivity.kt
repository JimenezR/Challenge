package com.platform.challenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.platform.challenge.R
import com.platform.challenge.databinding.ActivityMainBinding
import com.platform.challenge.ui.adapter.ProductAdapter
import com.platform.challenge.ui.model.ProductUI
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity @Inject constructor() : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ProductAdapter

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel.getProducts()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.productList.observe(this) {
            if (it.isNotEmpty()) {
                configRecycler(it)
                viewModel.setIsVisible(false)
            }
        }
    }

    private fun emptyState() {
        TODO("Not yet implemented")
    }

    private fun configRecycler(uiList: ArrayList<ProductUI>) {
        adapter = ProductAdapter { item, position -> }
        adapter.list = uiList
        binding.recyclerView.adapter = adapter
    }


}
