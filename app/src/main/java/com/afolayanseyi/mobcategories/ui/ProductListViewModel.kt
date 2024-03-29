package com.afolayanseyi.mobcategories.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afolayanseyi.mobcategories.data.MobCategoriesRepository
import com.afolayanseyi.mobcategories.data.model.MobCategory
import com.afolayanseyi.mobcategories.data.model.Result
import kotlinx.coroutines.launch

class ProductListViewModel(
    private val repository: MobCategoriesRepository
) : ViewModel() {

    val mobCategoriesLiveData = MutableLiveData<Result<List<MobCategory>>>()
    init {
        getMobCategories()
    }


    fun getMobCategories() {
        mobCategoriesLiveData.postValue(Result.Loading)
        viewModelScope.launch {
            try {
                val categories = repository.getMobCategoriesAsync().await()
                mobCategoriesLiveData.postValue(Result.Success(categories))
            }  catch (exception: Exception) {
                mobCategoriesLiveData.postValue(Result.Error(exception))
            }

        }
    }
}