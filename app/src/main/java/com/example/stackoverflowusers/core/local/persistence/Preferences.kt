package com.example.stackoverflowusers.core.local.persistence

import android.app.Activity
import android.content.SharedPreferences
import com.example.stackoverflowusers.MyApp
import com.example.stackoverflowusers.core.local.model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Preferences @Inject constructor(myApp: MyApp, private val gson: Gson) {

    private var preferences: SharedPreferences
    private var editor: SharedPreferences.Editor

    init {
        this.preferences =
            myApp.getSharedPreferences(PREFERENCES_NAME, Activity.MODE_PRIVATE)
        this.editor = preferences.edit()
    }

    fun getUsers(): List<User>? {
        val json = preferences.getString(KEY_USERS, "")
        val type = object : TypeToken<List<User>>() {}.type
        return gson.fromJson(json, type)
    }

    fun persistUsers(users: List<User>) {
        val json = gson.toJson(users)
        editor.putString(KEY_USERS, json)
        editor.apply()
    }

    companion object {
        private const val PREFERENCES_NAME = "stackoverflow_preferences"
        private const val KEY_USERS = "users"
    }
}
