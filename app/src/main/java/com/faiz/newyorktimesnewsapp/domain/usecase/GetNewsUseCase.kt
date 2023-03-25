package com.faiz.newyorktimesnewsapp.domain.usecase

import com.faiz.newyorktimesnewsapp.domain.model.Result
import com.faiz.newyorktimesnewsapp.domain.model.NewsModel
import com.faiz.newyorktimesnewsapp.domain.model.ResponseModel
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

interface GetNewsUseCase {
    suspend fun getPopularNews(): Flow<Result<ResponseModel>>
    /** locally save/retrieve,delete news data */
    suspend fun getPopularNewsLocally(): List<NewsModel>
    suspend fun savePopularNews(list: List<NewsModel>)
    suspend fun deleteAll()
}