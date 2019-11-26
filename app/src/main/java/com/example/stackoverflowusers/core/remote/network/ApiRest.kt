package com.example.stackoverflowusers.core.remote.network

import com.example.stackoverflowusers.core.remote.model.StackOverflowEntity
import io.reactivex.Single
import retrofit2.http.GET

/**
 * The API for all the requests of the application
 */
interface ApiRest {

    @GET("/2.2/users?order=desc&sort=reputation&site=stackoverflow")
    fun getStackOverflowResponse(): Single<StackOverflowEntity>
}
