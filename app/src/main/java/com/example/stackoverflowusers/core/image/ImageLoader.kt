package com.example.stackoverflowusers.core.image

import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.example.stackoverflowusers.R
import javax.inject.Inject

class ImageLoader @Inject constructor(private val fragmentActivity: FragmentActivity) {

    fun loadThumbnail(profile: ImageView, url: String) {
        Glide.with(fragmentActivity)
            .load(url)
            .placeholder(R.drawable.ic_launcher_background)
            .into(profile)
    }
}
