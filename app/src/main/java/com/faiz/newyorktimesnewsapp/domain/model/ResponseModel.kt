package com.faiz.newyorktimesnewsapp.domain.model

import com.google.gson.annotations.SerializedName

data class ResponseModel(
    val status: String,
    val copyright: String,
    @SerializedName("num_results")
    val numResults: Int,
    val results: List<NewsModel>
)