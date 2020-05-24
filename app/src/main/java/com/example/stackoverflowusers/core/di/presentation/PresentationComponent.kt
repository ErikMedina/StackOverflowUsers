package com.example.stackoverflowusers.core.di.presentation

import com.example.stackoverflowusers.core.di.ActivityScope
import com.example.stackoverflowusers.feature.user.MainActivity
import com.example.stackoverflowusers.feature.user.UserDetailFragment
import com.example.stackoverflowusers.feature.user.UserListFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [PresentationModule::class])
interface PresentationComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): PresentationComponent
    }

    fun inject(mainActivity: MainActivity)

    fun inject(userListFragment: UserListFragment)

    fun inject(userDetailFragment: UserDetailFragment) {
    }
}
