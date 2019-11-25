package com.example.stackoverflowusers.core.image

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.stackoverflowusers.R
import javax.inject.Inject

class ImageLoader @Inject constructor(private val context: Context) {

    fun loadThumbnail(profile: ImageView, url: String) {
        Glide.with(context)
            .load(url)
            .placeholder(R.drawable.ic_launcher_background)
            .into(profile)
    }
}
