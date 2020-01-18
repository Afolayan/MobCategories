package com.afolayanseyi.mobcategories.app

import android.app.Application
import com.afolayanseyi.mobcategories.di.appModule
import com.afolayanseyi.mobcategories.di.imageLoader
import com.afolayanseyi.mobcategories.di.repositoryModule
import com.afolayanseyi.mobcategories.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MobCategoryApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MobCategoryApplication)
            androidLogger()
            modules(listOf(appModule, imageLoader, repositoryModule, viewModelModule))
        }
    }
}
