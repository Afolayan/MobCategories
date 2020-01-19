package com.afolayanseyi.mobcategories.di

import com.afolayanseyi.mobcategories.ui.ProductListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ProductListViewModel(get()) }
}