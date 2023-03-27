package com.faiz.newyorktimesnewsapp.domain.usecase


import com.faiz.newyorktimesnewsapp.data.mapper.Mapper
import com.faiz.newyorktimesnewsapp.domain.model.NewsModel
import com.faiz.newyorktimesnewsapp.domain.repository.NewsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FetchNewsUseCaseRxJavaImpl @Inject constructor(
        private val repository: NewsRepository,
        private val mapper: Mapper
) : FetchNewsUseCaseRxJava {

    override fun execute(
        onSuccess: ((t: List<NewsModel>) -> Unit),
        onError: ((t: Throwable) -> Unit),
    ) {
        repository.getPopularNewsRxJava()
                .map(mapper::map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
            .subscribe(onSuccess,onError)
    }
}
