package com.example.stackoverflowusers.core.local.persistence

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.example.stackoverflowusers.core.local.Storage
import com.example.stackoverflowusers.core.local.model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesStorage @Inject constructor(applicationContext: Context, private val gson: Gson) : Storage {

    private var preferences: SharedPreferences
    private var editor: SharedPreferences.Editor

    init {
        this.preferences =
            applicationContext.getSharedPreferences(PREFERENCES_NAME, Activity.MODE_PRIVATE)
        this.editor = preferences.edit()
    }

    override fun getUsers(): List<User> {//TODO: return empty list if there are no stored users
        val json = preferences.getString(KEY_USERS, "")
        val type = object : TypeToken<List<User>>() {}.type
        return gson.fromJson(json, type)
    }

    override fun persistUsers(users: List<User>) {
        val json = gson.toJson(users)
        editor.putString(KEY_USERS, json)
        editor.apply()
    }

    companion object {
        private const val PREFERENCES_NAME = "stackoverflow_preferences"
        private const val KEY_USERS = "users"
    }
}
