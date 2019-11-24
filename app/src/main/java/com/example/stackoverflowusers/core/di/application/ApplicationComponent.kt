package com.example.stackoverflowusers.core.di.application

import com.example.stackoverflowusers.MyApp
import dagger.Component

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(myApp: MyApp)
}
