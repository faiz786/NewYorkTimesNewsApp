package com.faiz.newyorktimesnewsapp.domain.model

import com.google.gson.annotations.SerializedName

data class NewsModel(
    val id: Long,
    val source: String,
    @SerializedName("published_date")
    val publishedDate: String,
    val byline: String,
    val type: String,
    val title: String,
    @SerializedName("abstract")
    val abstractNews: String,
    val media: List<MediaModel>?
) {
    /** return thumbnail image of news with 75x75 **/
    fun thumbnailImg(): String? {
        return try {
            media?.get(0)?.mediaMeta?.get(0)?.url
        } catch (@Suppress("SwallowedException") e: java.lang.IndexOutOfBoundsException) {
            null
        }
    }

    /**
     *  return full image of news 140x210
     * fallback will return thumbnail else null
     *
     * **/
    fun fullImg(): String? {
        return try {
            media?.get(0)?.mediaMeta?.get(2)?.url
        } catch (@Suppress("SwallowedException") e: java.lang.IndexOutOfBoundsException) {
            try {
                media?.get(0)?.mediaMeta?.get(0)?.url
            } catch (@Suppress("SwallowedException") e: java.lang.IndexOutOfBoundsException) {
                null
            }
        }
    }
}