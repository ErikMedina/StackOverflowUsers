package com.example.stackoverflowusers.core.di.application

import com.example.stackoverflowusers.core.network.ApiRest
import com.example.stackoverflowusers.core.network.Retrofit
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    fun provideApiRest(retrofit: Retrofit) : ApiRest {
        return retrofit.apiRest()
    }
}
