package ru.allaber.shoppinglist.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ru.allaber.shoppinglist.R
import ru.allaber.shoppinglist.presentation.adapter.ShopListAdapter
import ru.allaber.shoppinglist.presentation.adapter.ShopListAdapter.Companion.MAX_POOL_SIZE
import ru.allaber.shoppinglist.presentation.adapter.ShopListAdapter.Companion.VIEW_TYPE_DISABLED
import ru.allaber.shoppinglist.presentation.adapter.ShopListAdapter.Companion.VIEW_TYPE_ENABLED
import ru.allaber.shoppinglist.presentation.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ShopListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this) {
            adapter.shopList = it
        }
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        adapter = ShopListAdapter()

        with(recyclerView) {
            recycledViewPool.setMaxRecycledViews(VIEW_TYPE_ENABLED, MAX_POOL_SIZE)
            recycledViewPool.setMaxRecycledViews(VIEW_TYPE_DISABLED, MAX_POOL_SIZE)
            adapter = adapter
        }
    }
}
