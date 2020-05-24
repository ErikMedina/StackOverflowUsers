package com.example.stackoverflowusers.core.image

import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.example.stackoverflowusers.R
import com.example.stackoverflowusers.core.di.BaseActivityScope
import javax.inject.Inject

@BaseActivityScope
class ImageLoader @Inject constructor(private val fragmentActivity: FragmentActivity) {

    fun loadThumbnail(profile: ImageView, url: String) {
        Glide.with(fragmentActivity)
            .load(url)
            .placeholder(R.drawable.ic_launcher_background)
            .into(profile)
    }
}
