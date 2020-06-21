package com.example.stackoverflowusers

import android.app.Application
import com.example.stackoverflowusers.core.di.component.ApplicationComponent
import com.example.stackoverflowusers.core.di.component.DaggerApplicationComponent
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp : Application() {

    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent
            .factory()
            .create(this)
    }
}
