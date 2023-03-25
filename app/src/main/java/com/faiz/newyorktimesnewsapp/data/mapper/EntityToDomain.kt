package com.faiz.newyorktimesnewsapp.data.mapper

import com.faiz.newyorktimesnewsapp.domain.model.NewsModel
import com.faiz.newyorktimesnewsapp.data.source.local.entitiy.NewsEntity

internal fun NewsEntity.toDomain() = NewsModel(
    id = id,
    source = source,
    publishedDate = publishedDate,
    byline = byline,
    type = type,
    title = title,
    abstractNews = abstractNews,
    media = media
)

internal fun List<NewsEntity>.toDomain(): List<NewsModel> {
    return this.map { it.toDomain() }
}

