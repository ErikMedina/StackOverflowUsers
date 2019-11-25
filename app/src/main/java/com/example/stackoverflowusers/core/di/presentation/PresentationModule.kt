package com.example.stackoverflowusers.core.di.presentation

import android.app.Activity
import android.content.Context
import androidx.fragment.app.FragmentActivity
import dagger.Module
import dagger.Provides

@Module
class PresentationModule(private val activity: FragmentActivity?) {

    /**
     * This function provides the enclosing activity as Context so we ensure that we're using
     * always the correct context and avoid memory leaks
     */
    @Provides
    internal fun provideContext(activity: Activity): Context {
        return activity
    }
}
