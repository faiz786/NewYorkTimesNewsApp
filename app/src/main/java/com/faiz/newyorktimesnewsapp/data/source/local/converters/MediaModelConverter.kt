package com.faiz.newyorktimesnewsapp.data.source.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.faiz.newyorktimesnewsapp.domain.model.MediaModel

class MediaModelConverter {
    @TypeConverter
    fun mediaModelListToString(list: List<MediaModel>): String {
        val gson = Gson()
        val type = object : TypeToken<List<MediaModel>>() {}.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    fun stringToMediaModelList(string: String): ArrayList<MediaModel> {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<MediaModel>>() {}.type
        return gson.fromJson(string, type)
    }
}