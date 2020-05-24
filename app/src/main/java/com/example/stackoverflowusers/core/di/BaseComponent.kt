package com.example.stackoverflowusers.core.di

import androidx.fragment.app.FragmentActivity
import com.example.stackoverflowusers.core.di.presentation.PresentationComponent
import dagger.BindsInstance
import dagger.Subcomponent

@BaseActivityScope
@Subcomponent(modules = [BaseSubcomponents::class])
interface BaseComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance fragmentActivity: FragmentActivity): BaseComponent
    }

    fun presentationComponent(): PresentationComponent.Factory
}
