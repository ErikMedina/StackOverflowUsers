package com.example.stackoverflowusers.core.di.application

import com.example.stackoverflowusers.MyApp
import com.example.stackoverflowusers.core.di.presentation.PresentationComponent
import com.example.stackoverflowusers.core.di.presentation.PresentationModule
import dagger.Component

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(myApp: MyApp)

    /**
     * This is a factory function which returns the subcomponent PresentationComponent
     *
     * We want PresentationComponent to be a subcomponent (child) of MyAppComponent (parent) so the
     * child can access to its parent's services (dependencies).
     *
     * Then, this function ties the relationship between PresentationComponent and MyAppComponent.
     */
    fun newPresentationComponent(presentationModule: PresentationModule): PresentationComponent
}
