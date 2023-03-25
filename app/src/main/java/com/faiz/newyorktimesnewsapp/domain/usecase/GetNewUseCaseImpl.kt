package com.faiz.newyorktimesnewsapp.domain.usecase

import com.faiz.newyorktimesnewsapp.domain.model.Result
import com.faiz.newyorktimesnewsapp.domain.model.NewsModel
import com.faiz.newyorktimesnewsapp.domain.model.ResponseModel
import com.faiz.newyorktimesnewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNewUseCaseImpl @Inject constructor(private val newsRepo: NewsRepository) :
    GetNewsUseCase {

    override suspend fun getPopularNews(): Flow<Result<ResponseModel>> {
        return newsRepo.getPopularNews()
    }

    override suspend fun getPopularNewsLocally(): List<NewsModel> {
        return newsRepo.getPopularNewsLocally()
    }

    override suspend fun savePopularNews(list: List<NewsModel>) {
        newsRepo.savePopularNews(list)
    }

    override suspend fun deleteAll() {
        newsRepo.deleteAll()
    }
}