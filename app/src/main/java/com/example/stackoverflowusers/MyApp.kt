package com.example.stackoverflowusers

import android.app.Application
import com.example.stackoverflowusers.core.di.application.ApplicationComponent
import com.example.stackoverflowusers.core.di.application.ApplicationModule
import com.example.stackoverflowusers.core.di.application.DaggerApplicationComponent

class MyApp : Application() {

    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent.inject(this)
    }
}
