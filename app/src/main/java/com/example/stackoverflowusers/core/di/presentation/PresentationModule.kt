package com.example.stackoverflowusers.core.di.presentation

import android.content.Context
import androidx.fragment.app.FragmentActivity
import dagger.Module
import dagger.Provides

@Module
class PresentationModule(private val activity: FragmentActivity) {

    @Provides
    internal fun provideActivity(): FragmentActivity {
        return activity
    }

    /**
     * This function provides the enclosing activity as Context so we ensure that we're using
     * always the correct context (current Activity) and avoid memory leaks
     */
    @Provides
    internal fun provideContext(activity: FragmentActivity): Context {
        return activity
    }
}
