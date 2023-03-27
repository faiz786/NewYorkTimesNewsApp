package com.faiz.newyorktimesnewsapp.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.faiz.newyorktimesnewsapp.domain.model.NewsModel


interface FetchNewsUseCaseRxJava {

    sealed class Result {
        data class OnSuccess(val news: List<NewsModel>) : Result()
        object OnError : Result()
    }

    fun execute(
                onSuccess: ((t: List<NewsModel>) -> Unit),
                onError: ((t: Throwable) -> Unit)
    )
}
