package com.faiz.newyorktimesnewsapp.domain.model

import com.google.gson.annotations.SerializedName

data class MediaModel(
    val type: String,
    @SerializedName("media-metadata")
    val mediaMeta: List<MediaMetaDataModel>?
)