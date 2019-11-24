package com.example.stackoverflowusers.core.di.presentation

import com.example.stackoverflowusers.feature.user.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [PresentationModule::class])
interface PresentationComponent {

    fun inject(mainActivity: MainActivity)
}
