package com.example.stackoverflowusers.core.di.module

import com.example.stackoverflowusers.core.image.GlideLoader
import com.example.stackoverflowusers.core.image.ImageLoader
import com.example.stackoverflowusers.core.remote.network.ApiRest
import com.example.stackoverflowusers.core.remote.network.Retrofit
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {
    // TODO: add companion object so we can use @Binds and @Provides in the same module
    @Singleton
    @Provides
    fun provideApiRest(retrofit: Retrofit): ApiRest {
        return retrofit.apiRest()
    }

    @Singleton
    @Provides
    internal fun provideGson(): Gson {
        return Gson()
    }

    @Singleton
    @Provides //TODO: use @Binds
    fun provideImageProcessingFactory(glideLoader: GlideLoader): ImageLoader {
        return glideLoader
    }
}
