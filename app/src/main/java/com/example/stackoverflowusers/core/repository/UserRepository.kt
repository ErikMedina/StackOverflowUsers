package com.example.stackoverflowusers.core.repository

import com.example.stackoverflowusers.core.local.model.User
import com.example.stackoverflowusers.core.network.ApiRest
import io.reactivex.Single
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiRest: ApiRest) {

    fun getUsers(): Single<List<User>> {
        return apiRest.getStackOverflowResponse()
            .map { stackOverflowResponse ->
                val users = mutableListOf<User>()
                for (userEntity in stackOverflowResponse.userEntities) {
                    users.add(userEntity.toUser())
                }
                users
            }
    }
}
