package com.faiz.newyorktimesnewsapp.di

import android.content.Context
import androidx.room.Room
import com.faiz.newyorktimesnewsapp.data.source.local.NewsDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NewsDB {
        return Room.databaseBuilder(context, NewsDB::class.java, NewsDB.DATABASE_NAME)
            .build()
    }

    @Provides
    fun provideNewsDao(database: NewsDB) = database.newsDao()
}