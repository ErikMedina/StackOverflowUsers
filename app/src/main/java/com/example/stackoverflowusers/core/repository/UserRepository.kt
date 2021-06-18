package com.example.stackoverflowusers.core.repository

import com.example.stackoverflowusers.core.local.Storage
import com.example.stackoverflowusers.core.local.model.User
import com.example.stackoverflowusers.core.remote.network.ApiRest
import io.reactivex.Single
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val apiRest: ApiRest,
    private val preferencesStorage: Storage
) {

    fun getUsers(): Single<List<User>> {
        return apiRest.getStackOverflowResponse()
            .map { stackOverflowResponse ->
                stackOverflowResponse.userEntities.map { it.mapToUser() }
            }
    }

    fun persistUsers(users: List<User>) {
        preferencesStorage.persistUsers(users)
    }

    fun getUsersLocally(): Single<List<User>> {// TODO: get users locally should be handle by the repository
        val users = preferencesStorage.getUsers()
        return if (users == null) {
            Single.error(Throwable())
        } else {
            Single.just(users)
        }
    }
}
