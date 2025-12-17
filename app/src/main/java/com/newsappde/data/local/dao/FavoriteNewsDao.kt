package com.newsappde.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.newsappde.data.local.entity.FavoriteNewsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteNewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(favoriteNewsEntity: FavoriteNewsEntity)

    @Delete
    suspend fun deleteNews(favoriteNewsEntity: FavoriteNewsEntity)

    @Query("SELECT * FROM NEWS_TABLE")
    fun getAllNews(): Flow<List<FavoriteNewsEntity>>
}