package com.example.stackoverflowusers.feature.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stackoverflowusers.core.usecase.GetUsersUseCase
import com.example.stackoverflowusers.core.viewmodel.Result
import com.example.stackoverflowusers.core.viewmodel.Status
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class UserViewModel(private val getUsersUseCase: GetUsersUseCase) : ViewModel() {

    private val disposables = CompositeDisposable()

    val result = MutableLiveData<Result>()

    fun getUsers() {
        disposables.add(getUsersUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { result.value = Result(status = Status.LOADING) }
            .subscribe(
                { users ->
                    result.value = Result(status = Status.SUCCESS, data = users)
                },
                { throwable ->
                    result.value = Result(status = Status.ERROR, error = throwable)
                }
            )
        )
    }
}
