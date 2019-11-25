package com.example.stackoverflowusers.core.viewmodel

import com.example.stackoverflowusers.core.local.model.User

class Result(
    val status: Status,
    val data: List<User> = emptyList(),
    val error: Error? = null
)
