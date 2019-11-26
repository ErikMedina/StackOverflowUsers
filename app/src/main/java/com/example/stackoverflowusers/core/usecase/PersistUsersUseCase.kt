package com.example.stackoverflowusers.core.usecase

import com.example.stackoverflowusers.core.local.model.User
import com.example.stackoverflowusers.core.repository.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PersistUsersUseCase @Inject constructor(private val userRepository: UserRepository) {

    fun execute(users: List<User>) {
        userRepository.persistUsers(users)
    }
}
