package com.example.stackoverflowusers.core.local.model

data class User(
    val userId: Int,
    val displayName: String,
    val profileImage: String,
    val reputation: Int
)
