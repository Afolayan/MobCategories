package com.afolayanseyi.mobcategories.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.afolayanseyi.mobcategories.model.MobCategory
import com.afolayanseyi.mobcategories.network.NetworkApi
import kotlinx.coroutines.*

class MainViewModel(
    val networkApi: NetworkApi,
    val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)
) : ViewModel() {

    val mobCategoriesLiveData = MutableLiveData<List<MobCategory>>()

    fun getMobCategories() {
        coroutineScope.launch {
            val breeds = networkApi.retrieveMobCategories().await()
            mobCategoriesLiveData.postValue(breeds)
        }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.coroutineContext.cancel()
    }
}