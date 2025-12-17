package com.newsappde.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.newsappde.data.local.dao.FavoriteNewsDao
import com.newsappde.data.local.entity.FavoriteNewsEntity

@Database(
    entities = [FavoriteNewsEntity::class],
    version = 1
)
abstract class FavoriteNewsDatabase : RoomDatabase() {
    abstract fun favoriteNewsDao(): FavoriteNewsDao
}