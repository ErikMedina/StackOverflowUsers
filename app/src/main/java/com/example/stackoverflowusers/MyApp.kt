package com.example.stackoverflowusers

import android.app.Application
import com.example.stackoverflowusers.core.di.application.ApplicationComponent
import com.example.stackoverflowusers.core.di.application.DaggerApplicationComponent

class MyApp : Application() {

    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent
            .factory()
            .create(this)
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent.inject(this)
    }
}
