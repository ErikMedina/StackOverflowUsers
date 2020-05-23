package com.example.stackoverflowusers.core.di.application

import android.content.Context
import com.example.stackoverflowusers.MyApp
import com.example.stackoverflowusers.core.di.StorageModule
import com.example.stackoverflowusers.core.di.presentation.PresentationComponent
import com.example.stackoverflowusers.core.di.presentation.PresentationModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Since in ApplicationModule there're dependencies scoped (have @Singleton annotation), we have to
 * scope ApplicationComponent as well
 */
@Singleton
@Component(modules = [ApplicationModule::class, StorageModule::class])
interface ApplicationComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): ApplicationComponent
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
    fun newPresentationComponent(presentationModule: PresentationModule): PresentationComponent
}
