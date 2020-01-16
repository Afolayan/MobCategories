package com.afolayanseyi.mobcategories.network

import com.afolayanseyi.mobcategories.model.MobCategory
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface NetworkApi {
    @GET
    fun retrieveMobCategories(): Deferred<List<MobCategory>>
}