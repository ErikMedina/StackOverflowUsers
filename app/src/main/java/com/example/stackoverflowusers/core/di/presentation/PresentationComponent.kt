package com.example.stackoverflowusers.core.di.presentation

import androidx.fragment.app.FragmentActivity
import com.example.stackoverflowusers.core.di.ActivityScope
import com.example.stackoverflowusers.feature.user.MainActivity
import com.example.stackoverflowusers.feature.user.UserDetailFragment
import com.example.stackoverflowusers.feature.user.UserListFragment
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [PresentationModule::class])
interface PresentationComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance fragmentActivity: FragmentActivity): PresentationComponent
    }

    fun inject(mainActivity: MainActivity)

    fun inject(userListFragment: UserListFragment)

    fun inject(userDetailFragment: UserDetailFragment) {
    }
}
