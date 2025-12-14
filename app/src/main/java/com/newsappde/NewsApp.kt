package com.newsappde

import android.app.Application
import com.newsappde.di.repositoryModule
import com.newsappde.di.retrofitModule
import com.newsappde.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NewsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@NewsApp)
            modules(
                listOf(
                    repositoryModule,
                    retrofitModule,
                    useCaseModule
                )
            )
        }
    }
}