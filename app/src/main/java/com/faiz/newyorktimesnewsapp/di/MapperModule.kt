package com.faiz.newyorktimesnewsapp.di

import com.faiz.newyorktimesnewsapp.data.mapper.Mapper
import com.faiz.newyorktimesnewsapp.data.source.remote.apis.NewsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {
    @Provides
    @Singleton
    fun provideMapper(): Mapper = Mapper()
}