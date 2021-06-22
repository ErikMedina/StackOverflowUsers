package com.example.stackoverflowusers.feature.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stackoverflowusers.core.di.scope.ActivityScope
import com.example.stackoverflowusers.core.local.model.User
import com.example.stackoverflowusers.core.usecase.GetUsersUseCase
import com.example.stackoverflowusers.core.viewmodel.Error
import com.example.stackoverflowusers.core.viewmodel.Result
import com.example.stackoverflowusers.core.viewmodel.Status
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@ActivityScope
class UserViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    var user: User? = null

    val result = MutableLiveData<Result>()

    private val disposables = CompositeDisposable()

    fun getUsers() {
        disposables.add(getUsersUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { result.value = Result(status = Status.LOADING) }
            .subscribe(
                { users ->
                    result.value = Result(status = Status.SUCCESS, data = users)
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
