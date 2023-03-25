package com.faiz.newyorktimesnewsapp.di

import com.faiz.newyorktimesnewsapp.data.source.local.dao.NewsDao
import com.faiz.newyorktimesnewsapp.data.source.remote.apis.NewsApi
import com.faiz.newyorktimesnewsapp.data.repository.NewsRepositoryImpl
import com.faiz.newyorktimesnewsapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideNewsRepo(api: NewsApi, dao: NewsDao): NewsRepository = NewsRepositoryImpl(api, dao)
}