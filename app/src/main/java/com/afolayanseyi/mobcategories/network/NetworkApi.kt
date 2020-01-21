package com.afolayanseyi.mobcategories.network

import com.afolayanseyi.mobcategories.data.model.MobCategory
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface NetworkApi {

    @GET("/")
    fun fetchMobCategories(): Deferred<List<MobCategory>>
}