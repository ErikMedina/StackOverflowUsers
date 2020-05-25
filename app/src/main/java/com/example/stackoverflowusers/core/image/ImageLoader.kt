package com.example.stackoverflowusers.core.image

import android.widget.ImageView
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageLoader @Inject constructor() {//TODO: create factory

    fun loadThumbnail(profile: ImageView, url: String) {
//        Glide.with(fragmentActivity)
//            .load(url)
//            .placeholder(R.drawable.ic_launcher_background)
//            .into(profile)
    }
}
