package com.example.stackoverflowusers.core.viewmodel

class Result(
    val status: Status,
//    val data: List<Post> = emptyList(),
    val error: Throwable? = null
)
