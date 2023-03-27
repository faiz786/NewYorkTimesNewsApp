package com.faiz.newyorktimesnewsapp.di

import com.faiz.newyorktimesnewsapp.data.mapper.Mapper
import com.faiz.newyorktimesnewsapp.domain.repository.NewsRepository
import com.faiz.newyorktimesnewsapp.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetNewsUseCase(repo: NewsRepository): GetNewsUseCase = GetNewUseCaseImpl(repo)

    @Provides
    @Singleton
    fun provideGetNewsUseCaseRxJava(repo: NewsRepository): GetNewsUseCaseRxJava = GetNewsUseCaseRxJava(repo)

    @Provides
    @Singleton
    fun provideFetchNewsUseCaseRxJava(repo: NewsRepository,mapper: Mapper): FetchNewsUseCaseRxJava = FetchNewsUseCaseRxJavaImpl(repo,mapper)
}