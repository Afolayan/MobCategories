package com.afolayanseyi.mobcategories.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.afolayanseyi.mobcategories.R
import com.afolayanseyi.mobcategories.data.model.Result
import com.afolayanseyi.mobcategories.ui.MainViewModel
import com.afolayanseyi.mobcategories.ui.MobCategoryAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) mainViewModel.getMobCategories()
        mainViewModel.mobCategoriesLiveData.observe(this, Observer { result ->
            when(result) {
                is Result.Loading -> {
                    showProgress()
                }
                is Result.Success -> {
                    hideProgress()
                    recycler.apply {
                        val categoriesList = result.data
                        Log.e("MainActivity", "size is ${categoriesList.size}")
                        adapter = MobCategoryAdapter(categoriesList)
                        layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                }
                is Result.Error -> {
                    hideProgress()
                }
            }

        })
    }

    private fun hideProgress() {
        //TODO Hide progress dialog here
    }

    private fun showProgress() {

        //TODO show progress dialog here
    }
}
