package com.example.stackoverflowusers.core.di.presentation

import com.example.stackoverflowusers.core.usecase.GetUsersUseCase
import com.example.stackoverflowusers.core.usecase.PersistUsersUseCase
import com.example.stackoverflowusers.core.usecase.RetrieveUsersUseCase
import com.example.stackoverflowusers.core.viewmodel.ViewModelFactory
import com.example.stackoverflowusers.feature.user.UserViewModel
import dagger.Module
import dagger.Provides

/**
 * This Dagger module holds all the ViewModels we need to provide.
 *
 * The Android ViewModel is a component which can't be inject directly, so we need a ViewModelFactory
 * which will inject and will provide the dependencies of type ViewModel
 */
@Module
class ViewModelModule {

    @Provides
    fun provideViewModelFactory(userViewModel: UserViewModel): ViewModelFactory {
        return ViewModelFactory(userViewModel)
    }

    @Provides
    fun providesUserViewModel(
        getUsersUseCase: GetUsersUseCase,
        persistUsersUseCase: PersistUsersUseCase,
        retrieveUsersUseCase: RetrieveUsersUseCase
    ): UserViewModel {
        return UserViewModel(getUsersUseCase, persistUsersUseCase, retrieveUsersUseCase)
    }
}
