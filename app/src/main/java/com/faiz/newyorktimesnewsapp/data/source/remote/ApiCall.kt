package com.faiz.newyorktimesnewsapp.data.source.remote

import com.faiz.newyorktimesnewsapp.domain.model.Result
import com.faiz.newyorktimesnewsapp.domain.model.ResultResponse
import com.google.gson.Gson
import retrofit2.Response
import java.net.UnknownHostException

/**
 * this class is a wrapper for converting Retrofit Response to our custom Result class
 **/

object ApiCall {
    inline fun <reified T : Any> result(service: () -> Response<T>): Result<T> {

        var errorCode: Int? = null
        var errorMsg: String? = null

        return try {
            val result = service()
            errorCode = result.code()
            errorMsg = result.raw().message

            if (result.isSuccessful) {
                Result.Success(result.body()!!)
            } else {
                if (result.code() != ResultResponse.UN_AUTHORIZED) {
                    val gSon = Gson()
                    val baseApiError =
                        gSon.fromJson(result.errorBody()?.string(), ResultResponse::class.java)
                    if (baseApiError != null && baseApiError.message.isNotEmpty())
                        Result.GenericError(
                            result.code(),
                            baseApiError.message
                        )
                    else Result.GenericError(result.code(), errorMsg)
                } else {
                    Result.GenericError(result.code(), "Un-Authorized Error")

                }

            }
        } catch (@Suppress("SwallowedException") e: UnknownHostException) {
            if (errorCode != null && errorMsg != null) {
                Result.GenericError(errorCode, errorMsg)
            }

            Result.NetworkError
        }
    }

}