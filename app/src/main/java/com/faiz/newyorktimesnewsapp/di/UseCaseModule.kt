package com.faiz.newyorktimesnewsapp.di

import com.faiz.newyorktimesnewsapp.domain.repository.NewsRepository
import com.faiz.newyorktimesnewsapp.domain.usecase.GetNewsUseCase
import com.faiz.newyorktimesnewsapp.domain.usecase.GetNewUseCaseImpl
import com.faiz.newyorktimesnewsapp.domain.usecase.GetNewsUseCaseRxJava
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
}