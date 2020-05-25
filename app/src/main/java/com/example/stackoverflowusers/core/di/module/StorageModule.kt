package com.example.stackoverflowusers.core.di.module

import com.example.stackoverflowusers.core.local.Storage
import com.example.stackoverflowusers.core.local.persistence.PreferencesStorage
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface StorageModule {

    @Singleton
    @Binds
    fun provideStorage(storage: PreferencesStorage): Storage
}
