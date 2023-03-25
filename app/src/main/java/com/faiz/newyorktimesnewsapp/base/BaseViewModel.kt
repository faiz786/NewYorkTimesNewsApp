package com.faiz.newyorktimesnewsapp.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.faiz.newyorktimesnewsapp.util.NavigationCommand
import com.faiz.newyorktimesnewsapp.util.RequestHandle
import com.faiz.newyorktimesnewsapp.util.SingleLiveEvent

abstract class BaseViewModel : ViewModel() {
    val navigationCommands = SingleLiveEvent<NavigationCommand>()

    lateinit var shareViewModel: ShareViewModel

    private val _observeLoading = SingleLiveEvent<RequestHandle>()
    val observeLoading: LiveData<RequestHandle> = _observeLoading
    val isNoDataFoundEvent = SingleLiveEvent<Boolean>()

    fun setNoData(isNoData: Boolean) {
        isNoDataFoundEvent.value = isNoData
    }

    fun startLoading() {
        _observeLoading.postValue(
            RequestHandle(
                showLoading = true,
                isSuccess = false,
                message = ""
            )
        )
    }


    fun endLoading(errorMessage: String? = null) {
        _observeLoading.postValue(
            RequestHandle(
                showLoading = false,
                isSuccess = false,
                message = errorMessage ?: ""
            )
        )
    }
}