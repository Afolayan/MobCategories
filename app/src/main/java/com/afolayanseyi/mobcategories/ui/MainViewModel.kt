package com.afolayanseyi.mobcategories.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afolayanseyi.mobcategories.data.MobCategoriesRepository
import com.afolayanseyi.mobcategories.data.model.MobCategory
import com.afolayanseyi.mobcategories.data.model.Result
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: MobCategoriesRepository
) : ViewModel() {

    val mobCategoriesLiveData = MutableLiveData<Result<List<MobCategory>>>()

    fun getMobCategories() {
        mobCategoriesLiveData.postValue(Result.Loading)
        viewModelScope.launch {
            val categories = repository.getMobCategoriesAsync().await()
            mobCategoriesLiveData.postValue(Result.Success(categories))
        }
    }
}