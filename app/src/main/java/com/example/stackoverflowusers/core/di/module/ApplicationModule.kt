package com.example.stackoverflowusers.core.di.module

import com.example.stackoverflowusers.core.remote.network.ApiRest
import com.example.stackoverflowusers.core.remote.network.Retrofit
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

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
}
