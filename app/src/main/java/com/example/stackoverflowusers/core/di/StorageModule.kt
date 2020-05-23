package com.example.stackoverflowusers.core.di

import com.example.stackoverflowusers.core.local.Storage
import com.example.stackoverflowusers.core.local.persistence.PreferencesStorage
import dagger.Binds
import dagger.Module

@Module
interface StorageModule {

    @Binds
    fun provideStorage(storage: PreferencesStorage): Storage
}
