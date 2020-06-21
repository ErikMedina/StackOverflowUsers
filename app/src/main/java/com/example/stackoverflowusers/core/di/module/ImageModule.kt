package com.example.stackoverflowusers.core.di.module

import com.example.stackoverflowusers.core.image.GlideLoader
import com.example.stackoverflowusers.core.image.ImageLoader
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
abstract class ImageModule {

    @Binds
    abstract fun provideImageLoader(glideLoader: GlideLoader): ImageLoader
}
