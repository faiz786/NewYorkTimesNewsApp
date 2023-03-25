package com.faiz.newyorktimesnewsapp.domain.model

data class ResultResponse<T>(var result: T?) {

    companion object {
        private const val BAD_REQUEST = 400
        private const val CLIENT_TIMEOUT = 499
        const val UN_AUTHORIZED = 401
        private const val FORBIDDEN_ERROR = 403
    }

    var code: Int = 0
    var message: String = ""
        set(value) {
            field = value
            when {
                code in BAD_REQUEST..CLIENT_TIMEOUT && result == null -> {
                    if (code != UN_AUTHORIZED && code != FORBIDDEN_ERROR) {
                        if (message.isEmpty())
                            field = "Server Error"
                    } else {
                        field = "UnAuthorize"
                    }
                }
                else -> {
                    field = "Server Error"
                }
            }
        }

}