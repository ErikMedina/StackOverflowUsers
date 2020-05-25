package com.example.stackoverflowusers.core.image

import android.content.Context
import android.widget.ImageView

interface ImageLoader {

    fun loadThumbnail(context: Context, target: ImageView, url: String)
}
