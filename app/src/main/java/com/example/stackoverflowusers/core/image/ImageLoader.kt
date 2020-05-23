package com.example.stackoverflowusers.core.image

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.stackoverflowusers.R
import javax.inject.Inject

class ImageLoader @Inject constructor(private val applicationContext: Context) {//TODO: pass FragmentActivity, not Application context

    fun loadThumbnail(profile: ImageView, url: String) {
        Glide.with(applicationContext)
            .load(url)
            .placeholder(R.drawable.ic_launcher_background)
            .into(profile)
    }
}
