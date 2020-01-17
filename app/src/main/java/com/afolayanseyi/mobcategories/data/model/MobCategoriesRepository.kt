package com.afolayanseyi.mobcategories.data.model

import kotlinx.coroutines.Deferred

interface MobCategoriesRepository {
    suspend fun getMobCategoriesAsync(): Deferred<List<MobCategory>>
}