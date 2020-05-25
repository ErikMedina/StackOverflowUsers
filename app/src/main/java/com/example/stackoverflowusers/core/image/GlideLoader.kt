package com.example.stackoverflowusers.core.image

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.stackoverflowusers.R
import javax.inject.Inject

/**
 * It's not necessary to scope this class since its interface is already scoped.
 */
class GlideLoader @Inject constructor() : ImageLoader {

    override fun loadThumbnail(context: Context, target: ImageView, url: String) {
        Glide.with(context)
            .load(url)
            .placeholder(R.drawable.ic_launcher_background)
            .into(target)
    }
}
