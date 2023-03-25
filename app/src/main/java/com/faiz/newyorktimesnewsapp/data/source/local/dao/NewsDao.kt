package com.faiz.newyorktimesnewsapp.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.faiz.newyorktimesnewsapp.data.source.local.entitiy.NewsEntity

@Dao
interface NewsDao {

    @Query("SELECT * FROM popularNews")
    suspend fun getPopularNews(): List<NewsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(news: NewsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(popularNewsList: List<NewsEntity>)

    @Query("DELETE FROM popularNews")
    suspend fun deleteAll()
}