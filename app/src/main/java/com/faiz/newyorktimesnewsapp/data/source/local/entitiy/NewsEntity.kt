package com.faiz.newyorktimesnewsapp.data.source.local.entitiy

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.faiz.newyorktimesnewsapp.domain.model.MediaModel
import com.faiz.newyorktimesnewsapp.data.source.local.converters.MediaModelConverter

@Entity(tableName = "popularNews")
data class NewsEntity(
    @PrimaryKey
    var id: Long,
    var source: String,
    var publishedDate: String,
    var byline: String,
    var type: String,
    var title: String,
    var abstractNews: String,
    @TypeConverters(MediaModelConverter::class)
    var media: List<MediaModel>?
) {
    constructor() : this(
        0,
        "",
        "",
        "",
        "",
        "",
        "",
        null
    )
}