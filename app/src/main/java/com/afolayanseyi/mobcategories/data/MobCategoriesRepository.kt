package com.afolayanseyi.mobcategories.data

import com.afolayanseyi.mobcategories.data.model.MobCategory
import kotlinx.coroutines.Deferred

interface MobCategoriesRepository {
    suspend fun getMobCategoriesAsync(): Deferred<List<MobCategory>>
}