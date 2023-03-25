package com.faiz.newyorktimesnewsapp.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.faiz.newyorktimesnewsapp.data.source.local.converters.MediaModelConverter
import com.faiz.newyorktimesnewsapp.data.source.local.dao.NewsDao
import com.faiz.newyorktimesnewsapp.data.source.local.entitiy.NewsEntity

@Database(entities = [NewsEntity::class], version = 1, exportSchema = false)
@TypeConverters(MediaModelConverter::class)
abstract class NewsDB : RoomDatabase() {

    abstract fun newsDao(): NewsDao

    companion object {
        const val DATABASE_NAME = "NEWS_DB"
    }
}