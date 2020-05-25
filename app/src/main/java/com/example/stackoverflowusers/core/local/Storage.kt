package com.example.stackoverflowusers.core.local

import com.example.stackoverflowusers.core.local.model.User

interface Storage {

    fun getUsers(): List<User>
    fun persistUsers(users: List<User>)
}
