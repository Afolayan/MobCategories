package com.afolayanseyi.mobcategories.data

import com.afolayanseyi.mobcategories.data.model.MobCategory
import com.afolayanseyi.mobcategories.network.NetworkApi
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MobCategoriesRepositoryImpl(private val networkApi: NetworkApi) :
    MobCategoriesRepository {
    override suspend fun getMobCategoriesAsync(): Deferred<List<MobCategory>> = withContext(Dispatchers.IO) {
        networkApi.fetchMobCategories()
    }

}