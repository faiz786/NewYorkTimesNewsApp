package com.faiz.newyorktimesnewsapp.domain.usecase

import com.faiz.newyorktimesnewsapp.domain.model.NewsModel
import com.faiz.newyorktimesnewsapp.domain.model.ResponseModel
import com.faiz.newyorktimesnewsapp.domain.repository.NewsRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * An interactor that calls the actual implementation of [AlbumViewModel](which is injected by DI)
 * it handles the response that returns data &
 * contains a list of actions, event steps
 */
class GetNewsUseCaseRxJava @Inject constructor(
    private val repository: NewsRepository
) : GetNewsUseCaseRxJavaImpl<ResponseModel>() {

    override fun buildUseCaseSingle(): Single<ResponseModel> {
        return repository.getPopularNewsRxJava()
    }

    suspend fun savePopularNews(list: List<NewsModel>) {
        repository.savePopularNews(list)
    }

    suspend fun getPopularNewsLocally(): List<NewsModel> {
        return repository.getPopularNewsLocally()
    }
}
