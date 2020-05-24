package com.example.stackoverflowusers.feature.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stackoverflowusers.core.di.ActivityScope
import com.example.stackoverflowusers.core.local.model.User
import com.example.stackoverflowusers.core.usecase.GetUsersLocallyUseCase
import com.example.stackoverflowusers.core.usecase.GetUsersUseCase
import com.example.stackoverflowusers.core.usecase.PersistUsersUseCase
import com.example.stackoverflowusers.core.viewmodel.Error
import com.example.stackoverflowusers.core.viewmodel.Result
import com.example.stackoverflowusers.core.viewmodel.Status
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@ActivityScope
class UserViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
    private val persistUsersUseCase: PersistUsersUseCase,
    private val getUsersLocallyUseCase: GetUsersLocallyUseCase
) : ViewModel() {

    var user: User? = null

    val result = MutableLiveData<Result>()

    private val disposables = CompositeDisposable()

    fun getUsers() {
        disposables.add(getUsersUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { result.value = Result(status = Status.LOADING) }
            .onErrorResumeNext { getUsersLocallyUseCase.execute() } //replaces the current stream with an entirely new Observable
            .subscribe(
                { users ->
                    result.value = Result(status = Status.SUCCESS, data = users)
                    persistUsersUseCase.execute(users)
                },
                {
                    result.value = Result(status = Status.ERROR, error = Error(Error.Type.NO_USERS))
                }
            )
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}
