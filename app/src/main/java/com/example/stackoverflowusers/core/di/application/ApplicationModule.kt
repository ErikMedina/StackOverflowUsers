package com.example.stackoverflowusers.core.di.application

import com.example.stackoverflowusers.MyApp
import com.example.stackoverflowusers.core.network.ApiRest
import com.example.stackoverflowusers.core.network.Retrofit
import com.google.gson.Gson
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val myApp: MyApp) {

    @Provides
    internal fun provideApplication(): MyApp {
        return myApp
    }

    @Provides
    fun provideApiRest(retrofit: Retrofit): ApiRest {
        return retrofit.apiRest()
    }

    @Provides
    internal fun provideGson(): Gson {
        return Gson()
    }
}
