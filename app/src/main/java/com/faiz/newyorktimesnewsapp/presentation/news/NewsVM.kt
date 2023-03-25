package com.faiz.newyorktimesnewsapp.presentation.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.faiz.newyorktimesnewsapp.base.BaseViewModel
import com.faiz.newyorktimesnewsapp.domain.model.Result
import com.faiz.newyorktimesnewsapp.domain.model.NewsModel
import com.faiz.newyorktimesnewsapp.domain.usecase.GetNewsUseCase
import com.faiz.newyorktimesnewsapp.domain.usecase.GetNewsUseCaseRxJava
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsVM @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase,
    private val getNewsUseCaseRxJava: GetNewsUseCaseRxJava
) : BaseViewModel() {


    val observeNews: MutableLiveData<List<NewsModel>> = MutableLiveData()

    init {
//        getPopularNews()
        getPopularNewsRxJava()
    }

    private fun getPopularNewsRxJava() {
        startLoading()
        setNoData(false)
        getNewsUseCaseRxJava.execute(
            onSuccess = {
                val list = it.results
                endLoading()
                setNoData(list.isEmpty())
                viewModelScope.launch {
                    getNewsUseCaseRxJava.savePopularNews(list)
                }
                observeNews.postValue(list)
            },
            onError = {
                setNoData(false)
                endLoading(it.message)
                viewModelScope.launch {
                    observeNews.postValue(getNewsUseCaseRxJava.getPopularNewsLocally())
                }
            }
        )
    }

    private fun getPopularNews() {
        startLoading()
        setNoData(false)
        viewModelScope.launch {
            getNewsUseCase.getPopularNews()
                .collect {
                    when (it) {
                        is Result.Success -> {
                            val list = it.data.results
                            endLoading()
                            setNoData(list.isEmpty())
                            getNewsUseCase.savePopularNews(list)
                            observeNews.postValue(list)
                        }

                        is Result.GenericError -> {
                            setNoData(false)
                            endLoading(it.message)
                            observeNews.postValue(getNewsUseCase.getPopularNewsLocally())
                        }

                        is Result.NetworkError -> {
                            setNoData(false)
                            endLoading("Network Error")
                            observeNews.postValue(getNewsUseCase.getPopularNewsLocally())
                        }
                    }
                }
        }


    }
}