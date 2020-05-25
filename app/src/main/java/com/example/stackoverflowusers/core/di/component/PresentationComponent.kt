package com.example.stackoverflowusers.core.di.component

import com.example.stackoverflowusers.core.di.scope.ActivityScope
import com.example.stackoverflowusers.feature.user.MainActivity
import com.example.stackoverflowusers.feature.user.UserDetailFragment
import com.example.stackoverflowusers.feature.user.UserListFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface PresentationComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): PresentationComponent
    }

    fun inject(mainActivity: MainActivity)

    fun inject(userListFragment: UserListFragment)

    fun inject(userDetailFragment: UserDetailFragment)
}
