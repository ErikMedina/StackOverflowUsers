package com.example.stackoverflowusers

import androidx.appcompat.app.AppCompatActivity

/**
 * Activity declared as open so other activities can inherit from it
 *
 * It gives the PresentationComponent to its children so they can inject dependencies.
 */
open class BaseActivity : AppCompatActivity() {

}
