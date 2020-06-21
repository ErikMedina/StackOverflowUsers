package com.example.stackoverflowusers.core.di.module

import com.example.stackoverflowusers.core.local.Storage
import com.example.stackoverflowusers.core.local.persistence.PreferencesStorage
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
interface StorageModule {

    @Singleton
    @Binds
    fun provideStorage(storage: PreferencesStorage): Storage
}
