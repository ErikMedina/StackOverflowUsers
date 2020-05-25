package com.example.stackoverflowusers.core.di.module

import com.example.stackoverflowusers.core.image.GlideLoader
import com.example.stackoverflowusers.core.image.ImageLoader
import com.example.stackoverflowusers.core.remote.network.ApiRest
import com.example.stackoverflowusers.core.remote.network.Retrofit
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class ApplicationModule {

    @Binds
    abstract fun provideImageLoader(glideLoader: GlideLoader): ImageLoader

    @Module
    companion object {

        @Singleton
        @JvmStatic
        @Provides
        fun provideApiRest(retrofit: Retrofit): ApiRest {
            return retrofit.apiRest()
        }

        @Singleton
        @JvmStatic
        @Provides
        internal fun provideGson(): Gson {
            return Gson()
        }
    }
}
