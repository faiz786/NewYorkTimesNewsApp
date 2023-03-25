package com.faiz.newyorktimesnewsapp.data.repository

import com.faiz.newyorktimesnewsapp.domain.model.Result
import com.faiz.newyorktimesnewsapp.domain.model.NewsModel
import com.faiz.newyorktimesnewsapp.domain.model.ResponseModel
import com.faiz.newyorktimesnewsapp.data.source.local.dao.NewsDao
import com.faiz.newyorktimesnewsapp.data.mapper.toDomain
import com.faiz.newyorktimesnewsapp.data.mapper.toEntity
import com.faiz.newyorktimesnewsapp.data.source.remote.ApiCall
import com.faiz.newyorktimesnewsapp.data.source.remote.apis.NewsApi
import com.faiz.newyorktimesnewsapp.domain.repository.NewsRepository
import io.reactivex.Single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApi,
    private val dao: NewsDao
) : NewsRepository {
    override suspend fun getPopularNews(): Flow<Result<ResponseModel>> {
        return flow {
            emit(
                ApiCall.result {
                    api.getPopularNews()
                }
            )
        }.flowOn(Dispatchers.IO)
    }

    override fun getPopularNewsRxJava(): Single<ResponseModel> {
        return api.getPopularNewsRxJava()
    }

    override suspend fun getPopularNewsLocally(): List<NewsModel> {
        return withContext(Dispatchers.IO) {
            dao.getPopularNews().toDomain()
        }
    }

    override suspend fun savePopularNews(list: List<NewsModel>) {
        withContext(Dispatchers.IO) {
            dao.insertAll(list.toEntity())
        }
    }

    override suspend fun deleteAll() {
        withContext(Dispatchers.IO) {
            dao.deleteAll()
        }
    }
}