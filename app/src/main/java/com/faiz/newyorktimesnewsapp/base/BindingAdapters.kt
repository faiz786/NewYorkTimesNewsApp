package com.faiz.newyorktimesnewsapp.base

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.faiz.newyorktimesnewsapp.R

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("loadImg")
    fun loadImageUrl(view: ImageView, url: String?) {
        Glide.with(view.context)
            .load(url)
            .placeholder(R.color.placeHolder)
            .error(R.color.red)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).into(view)
    }
}