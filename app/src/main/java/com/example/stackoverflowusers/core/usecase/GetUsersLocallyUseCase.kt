package com.example.stackoverflowusers.core.usecase

import com.example.stackoverflowusers.core.local.model.User
import com.example.stackoverflowusers.core.repository.UserRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetUsersLocallyUseCase @Inject constructor(private val userRepository: UserRepository) {

    fun execute(): Single<List<User>> {
        return userRepository.getUsersLocally()
    }
}
