package com.newsappde.di

import android.content.Context
import androidx.room.Room
import com.newsappde.data.local.dao.FavoriteNewsDao
import com.newsappde.data.local.database.FavoriteNewsDatabase
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get<Context>(),
            FavoriteNewsDatabase::class.java,
            "newsTable"
        )
            .fallbackToDestructiveMigration(false)
            .build()
    }
    single<FavoriteNewsDao> { get<FavoriteNewsDatabase>().favoriteNewsDao() }
}