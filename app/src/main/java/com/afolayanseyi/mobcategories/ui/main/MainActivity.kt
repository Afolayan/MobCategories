package com.afolayanseyi.mobcategories.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.afolayanseyi.mobcategories.R
import com.afolayanseyi.mobcategories.ui.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
