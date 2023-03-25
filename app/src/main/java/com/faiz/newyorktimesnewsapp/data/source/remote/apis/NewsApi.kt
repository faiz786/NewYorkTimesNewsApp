package com.faiz.newyorktimesnewsapp.data.source.remote.apis

import com.faiz.newyorktimesnewsapp.domain.model.ResponseModel
import com.faiz.newyorktimesnewsapp.data.commons.ApiEndPoints
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsApi {
    @Headers("Content-Type: application/json")
    @GET(ApiEndPoints.MOST_POPULAR)
    suspend fun getPopularNews(
        @Query("api-key") apiKey: String = "N8x5EIppmwphXT8oGkzmclvkedpeg7j5"
    ): Response<ResponseModel>

    @Headers("Content-Type: application/json")
    @GET(ApiEndPoints.MOST_POPULAR)
    fun getPopularNewsRxJava(
        @Query("api-key") apiKey: String = "N8x5EIppmwphXT8oGkzmclvkedpeg7j5"
    ): Single<ResponseModel>
}