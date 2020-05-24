package com.example.stackoverflowusers.core.di.application

import android.content.Context
import com.example.stackoverflowusers.MyApp
import com.example.stackoverflowusers.core.di.ApplicationSubcomponents
import com.example.stackoverflowusers.core.di.BaseComponent
import com.example.stackoverflowusers.core.di.StorageModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * ApplicationComponent is the component that holds the graph that will be attached to the app's
 * lifecycle. We annotate this component with @Singleton because we want that the classes annotated
 * with @Singleton are scoped to its lifetime (app's lifecycle).
 */
@Singleton
@Component(modules = [ApplicationModule::class, StorageModule::class, ApplicationSubcomponents::class])
interface ApplicationComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }

    fun inject(myApp: MyApp)

    /**
     * This is a factory function which returns the subcomponent PresentationComponent
     *
     * We want PresentationComponent to be a subcomponent (child) of MyAppComponent (parent) so the
     * child can access to its parent's services (dependencies).
     *
     * Then, this function ties the relationship between PresentationComponent and MyAppComponent.
     */
//    fun newPresentationComponent(presentationModule: PresentationModule): PresentationComponent

    fun baseComponent(): BaseComponent.Factory
}
