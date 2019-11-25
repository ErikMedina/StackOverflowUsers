package com.example.stackoverflowusers.feature.user.adapter

import android.util.Log
import com.example.stackoverflowusers.core.local.model.User

class OnUserClickListenerImpl : OnUserClickListener {

    override fun onUserClick(user: User) {
        Log.d(TAG, "[onUserClick] user selected: ${user.displayName}")

    }

    companion object {
        private const val TAG = "OnUserClickListenerImpl"
    }
}
