package com.afolayanseyi.mobcategories.ui.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.afolayanseyi.mobcategories.R
import com.afolayanseyi.mobcategories.data.model.Result
import com.afolayanseyi.mobcategories.databinding.ActivityMainBinding
import com.afolayanseyi.mobcategories.ui.MainViewModel
import com.afolayanseyi.mobcategories.ui.MobCategoryAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var activityBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        activityBinding.viewModel = mainViewModel

        if (savedInstanceState == null) mainViewModel.getMobCategories()
        mainViewModel.mobCategoriesLiveData.observe(this, Observer { result ->
            when(result) {
                is Result.Loading -> {
                    showProgress()
                }
                is Result.Success -> {
                    hideProgress()
                    activityBinding.recycler.apply {
                        val categoriesList = result.data
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
        activityBinding.progressBar.visibility = View.GONE
    }

    private fun showProgress() {
        activityBinding.progressBar.visibility = View.VISIBLE
    }
}
