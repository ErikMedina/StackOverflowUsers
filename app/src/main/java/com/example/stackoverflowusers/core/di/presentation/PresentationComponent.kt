package com.example.stackoverflowusers.core.di.presentation

import com.example.stackoverflowusers.feature.user.MainActivity
import com.example.stackoverflowusers.feature.user.UserDetailFragment
import com.example.stackoverflowusers.feature.user.UserListFragment
import dagger.Subcomponent

@Subcomponent(modules = [PresentationModule::class, ViewModelModule::class])
interface PresentationComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(userListFragment: UserListFragment)

    fun inject(userDetailFragment: UserDetailFragment) {
    }
}
