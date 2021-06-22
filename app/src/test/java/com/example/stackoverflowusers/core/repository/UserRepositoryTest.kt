package com.example.stackoverflowusers.core.repository

import com.example.stackoverflowusers.core.local.Storage
import com.example.stackoverflowusers.core.remote.network.ApiRest
import com.example.stackoverflowusers.mockdata.UserMockData.localUsers
import com.example.stackoverflowusers.mockdata.UserMockData.stackOverflowEntity
import com.example.stackoverflowusers.mockdata.UserMockData.remoteUsers
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import io.reactivex.rxjava3.core.Single
import org.junit.After
import org.junit.Before
import org.junit.Test

class UserRepositoryTest {

    @MockK
    private lateinit var apiRest: ApiRest

    @MockK
    private lateinit var preferencesStorage: Storage

    private lateinit var sut: UserRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        sut = UserRepository(apiRest, preferencesStorage)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `When the users are fetched remotely, then they are stored locally`() {
        every { apiRest.getStackOverflowResponse() } returns Single.just(stackOverflowEntity)
        // Act
        sut.getUsers().test()
        // Assert
        verify { preferencesStorage.persistUsers(remoteUsers) }
    }

    @Test
    fun `Given there are no users stored, when the users are asked, then users from remote are returned`() {
        every { apiRest.getStackOverflowResponse() } returns Single.just(stackOverflowEntity)
        every { preferencesStorage.persistUsers(remoteUsers) } returns Unit
        // Act
        val test = sut.getUsers().test()
        // Assert
        test.assertValue(remoteUsers)
    }

    @Test
    fun `Given there are users stored, when the users are asked, then the stored users are returned`() {
        every { apiRest.getStackOverflowResponse() } returns Single.error(Throwable())
        every { preferencesStorage.persistUsers(remoteUsers) } returns Unit
        every { preferencesStorage.retrieveUsers() } returns localUsers
        // Act
        val test = sut.getUsers().test()
        // Assert
        test.assertValue(localUsers)
    }
}