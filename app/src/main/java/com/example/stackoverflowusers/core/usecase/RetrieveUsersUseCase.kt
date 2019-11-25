package com.example.stackoverflowusers.core.usecase

import com.example.stackoverflowusers.core.local.model.User
import com.example.stackoverflowusers.core.repository.UserRepository
import io.reactivex.Single
import javax.inject.Inject

class RetrieveUsersUseCase @Inject constructor(private val userRepository: UserRepository) {

    fun execute(): Single<List<User>> {
        return userRepository.retrieveUsers()
    }
}
