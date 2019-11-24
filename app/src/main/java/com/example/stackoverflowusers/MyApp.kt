package com.example.stackoverflowusers

import android.app.Application
import com.example.stackoverflowusers.core.di.application.ApplicationModule
import com.example.stackoverflowusers.core.di.application.DaggerApplicationComponent

class MyApp : Application() {

    private val myAppComponent by lazy {
        DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        myAppComponent.inject(this)
    }
}
