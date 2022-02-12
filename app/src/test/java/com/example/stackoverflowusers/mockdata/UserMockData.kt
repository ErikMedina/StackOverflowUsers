package com.example.stackoverflowusers.mockdata

import com.example.stackoverflowusers.core.local.model.User
import com.example.stackoverflowusers.core.remote.model.StackOverflowEntity
import com.example.stackoverflowusers.core.remote.model.UserEntity

object UserMockData {

    private const val userId1 = 1
    private const val displayName1 = "Name1"
    private const val profileImage1 = "https://url1.com"
    private const val reputation1 = 100
    private val userEntity1 = UserEntity(
        userId = userId1,
        displayName = displayName1,
        profileImage = profileImage1,
        reputation = reputation1
    )

    private const val userId2 = 2
    private const val displayName2 = "Name2"
    private const val profileImage2 = "https://url2.com"
    private const val reputation2 = 200
    private val userEntity2 = UserEntity(
        userId = userId2,
        displayName = displayName2,
        profileImage = profileImage2,
        reputation = reputation2
    )

    // User 3
    private const val userId3 = 3
    private const val displayName3 = "Name3"
    private const val profileImage3 = "https://url3.com"
    private const val reputation3 = 300

    val stackOverflowEntity = StackOverflowEntity(listOf(userEntity1, userEntity2))

    private val user1 = User(userId1, displayName1, profileImage1, reputation1)
    private val user2 = User(userId2, displayName2, profileImage2, reputation2)
    private val user3 = User(userId3, displayName3, profileImage3, reputation3)

    val localUsers = listOf(user1, user2, user3)
    val remoteUsers = listOf(user1, user2)

}
