package com.example.stackoverflowusers.feature.user

import android.os.Bundle
import com.example.stackoverflowusers.BaseActivity
import com.example.stackoverflowusers.R

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // Clients (in this case MainActivity) use Dagger component as injector to inject
        // services (dependencies) into themselves
        getPresentationComponent().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
