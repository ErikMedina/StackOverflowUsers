package com.example.stackoverflowusers.core.viewmodel

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.stackoverflowusers.feature.user.UserViewModel
import javax.inject.Inject

/**
 * This factory is in charge of the injection of ViewModels in runtime.
 */
class ViewModelFactory @Inject constructor(private val userViewModel: UserViewModel) :
    ViewModelProvider.Factory {

    @NonNull
    override fun <T : ViewModel> create(@NonNull modelClass: Class<T>): T {
        val viewModel: ViewModel
        if (modelClass == UserViewModel::class.java) {
            viewModel = userViewModel
        } else {
            throw RuntimeException("invalid view model class: $modelClass")
        }

        return viewModel as T
    }
}
