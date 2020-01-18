package com.afolayanseyi.mobcategories.di

import com.afolayanseyi.mobcategories.data.MobCategoriesRepository
import com.afolayanseyi.mobcategories.data.MobCategoriesRepositoryImpl
import com.afolayanseyi.mobcategories.network.NetworkApi
import com.afolayanseyi.mobcategories.utils.GlideImageLoader
import com.afolayanseyi.mobcategories.utils.baseUrl
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single { createRetrofit(createOkHttpClient()) }
    single { createNetworkApi(get()) }
}

val repositoryModule = module {
    single {
        MobCategoriesRepositoryImpl(get()) as MobCategoriesRepository
    }
}

val imageLoader = module {
    single {
        GlideImageLoader()
    }
}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor).build()
}

fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .build()
}

fun createNetworkApi(retrofit: Retrofit): NetworkApi {
    return retrofit.create(NetworkApi::class.java)
}