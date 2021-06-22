package com.example.stackoverflowusers.core.repository

import com.example.stackoverflowusers.core.local.Storage
import com.example.stackoverflowusers.core.local.model.User
import com.example.stackoverflowusers.core.remote.network.ApiRest
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val apiRest: ApiRest,
    private val preferencesStorage: Storage
) {

    fun getUsers(): Single<List<User>> {
        return apiRest.getStackOverflowResponse()
            .map { stackOverflowResponse ->
                val users = stackOverflowResponse.userEntities.map { it.mapToUser() }
                persistUsers(users)
                users
            }.onErrorResumeNext { retrieveUsers() }
    }

    private fun persistUsers(users: List<User>) {
        preferencesStorage.persistUsers(users)
    }

    private fun retrieveUsers(): Single<List<User>> {
        val users = preferencesStorage.retrieveUsers()
        return Single.just(users)
    }
}
