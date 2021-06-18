package com.example.stackoverflowusers.feature.user

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.stackoverflowusers.RxImmediateSchedulerRule
import com.example.stackoverflowusers.core.local.model.User
import com.example.stackoverflowusers.core.usecase.GetUsersLocallyUseCase
import com.example.stackoverflowusers.core.usecase.GetUsersUseCase
import com.example.stackoverflowusers.core.usecase.PersistUsersUseCase
import com.example.stackoverflowusers.core.viewmodel.Error
import com.example.stackoverflowusers.core.viewmodel.Result
import com.example.stackoverflowusers.core.viewmodel.Status
import io.mockk.Called
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import io.reactivex.Observable
import io.reactivex.Single
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class StackOverflowUserViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule() //make the LiveData works synchronously

    @Rule
    @JvmField
    var testSchedulerRule = RxImmediateSchedulerRule()

    @MockK
    private lateinit var observer: Observer<Result>

    @MockK
    private lateinit var getUsersUseCase: GetUsersUseCase

    @MockK(relaxUnitFun = true)
    private lateinit var persistUsersUseCase: PersistUsersUseCase

    @MockK
    private lateinit var getUsersLocallyUseCase: GetUsersLocallyUseCase

    private lateinit var sut: UserViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        sut = UserViewModel(getUsersUseCase, persistUsersUseCase, getUsersLocallyUseCase)
    }

    @Test
    fun `Users are fetched successfully`() {
        // Arrange
        every { getUsersUseCase.execute() } returns Single.error(Throwable())
        every { getUsersLocallyUseCase.execute() } returns Single.just(users)
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
    fun `getUsers when no error then zero interactions with retrieveUsersUseCase`() {
        // Arrange
        every { getUsersUseCase.execute() } returns getUsersSingle()
        // Act
        sut.getUsers()
        // Assert
        verify { getUsersLocallyUseCase wasNot Called }
    }

    @Test
    fun `getUsers when error then status is Error with no users`() {
        // Arrange
        every { getUsersUseCase.execute() } returns Single.error(Throwable())
        // Act
        sut.getUsers()
        // Assert
        sut.result.value?.run {
            assertThat(status, `is`(Status.ERROR))
            assertThat(error!!.type, `is`(Error.Type.NO_USERS))
        }
    }

    private fun getUsersSingle(): Single<List<User>> {


        return Single.fromObservable(Observable.just(users))
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
