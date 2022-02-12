package com.example.stackoverflowusers.feature.user

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.stackoverflowusers.RxImmediateSchedulerRule
import com.example.stackoverflowusers.core.local.model.User
import com.example.stackoverflowusers.core.repository.UserRepository
import com.example.stackoverflowusers.core.viewmodel.Error
import com.example.stackoverflowusers.core.viewmodel.Result
import com.example.stackoverflowusers.core.viewmodel.Status
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UserViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule() //make the LiveData works synchronously

    @Rule
    @JvmField
    var testSchedulerRule = RxImmediateSchedulerRule()

    private val observer: Observer<Result> = mockk()

    private val userRepository: UserRepository = mockk()

    private val sut = UserViewModel(userRepository)

    @Before
    fun setUp() {
        clearAllMocks()
    }

    @Test
    fun `Users are fetched successfully`() {
        // Arrange
        every { userRepository.getUsers() } returns Single.just(users)
        // Act
        sut.getUsers()
        // Assert
        sut.result.value?.run {
            assertThat(status, `is`(Status.SUCCESS))
            assertThat(data[0], `is`(user1))
            assertThat(data[1], `is`(user2))
            assertThat(data[2], `is`(user3))
        }
    }

    @Test
    fun `getUsers when error then status is Error with no users`() {
        // Arrange
        every { userRepository.getUsers() } returns Single.error(Throwable())
        // Act
        sut.getUsers()
        // Assert
        sut.result.value?.run {
            assertThat(status, `is`(Status.ERROR))
            assertThat(error!!.type, `is`(Error.Type.NO_USERS))
        }
    }

    private val user1 = User(USER_ID_1, NAME_1, PROFILE_IMAGE_1, REPUTATION_1)

    private val user2 = User(USER_ID_2, NAME_2, PROFILE_IMAGE_2, REPUTATION_2)
    private val user3 = User(USER_ID_3, NAME_3, PROFILE_IMAGE_3, REPUTATION_3)

    //--------------- HELPERS -----------------------------//
    val users = listOf(user1, user2, user3)
    val users2 = listOf(user1, user2, user2)

    companion object {
        private const val USER_ID_1 = 1
        private const val USER_ID_2 = 2
        private const val USER_ID_3 = 3

        private const val NAME_1 = "name1"
        private const val NAME_2 = "name2"
        private const val NAME_3 = "name3"

        private const val PROFILE_IMAGE_1 = "profileImage1"
        private const val PROFILE_IMAGE_2 = "profileImage2"
        private const val PROFILE_IMAGE_3 = "profileImage3"

        private const val REPUTATION_1 = 1
        private const val REPUTATION_2 = 2
        private const val REPUTATION_3 = 3
    }
}
