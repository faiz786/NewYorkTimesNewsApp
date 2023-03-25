package com.faiz.newyorktimesnewsapp.base

import androidx.lifecycle.ViewModel
import com.faiz.newyorktimesnewsapp.domain.model.NewsModel

class ShareViewModel : ViewModel() {
    var news: NewsModel? = null
}