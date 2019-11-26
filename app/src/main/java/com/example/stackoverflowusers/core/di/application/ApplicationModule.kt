package com.example.stackoverflowusers.core.di.application

import com.example.stackoverflowusers.MyApp
import com.example.stackoverflowusers.core.remote.network.ApiRest
import com.example.stackoverflowusers.core.remote.network.Retrofit
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val myApp: MyApp) {

    @Provides
    internal fun provideApplication(): MyApp {
        return myApp
    }

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
