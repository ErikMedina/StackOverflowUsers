package com.example.stackoverflowusers

import androidx.annotation.UiThread
import androidx.appcompat.app.AppCompatActivity
import com.example.stackoverflowusers.core.di.presentation.PresentationComponent
import com.example.stackoverflowusers.core.di.presentation.PresentationModule

/**
 * Activity declared as open so other activities can inherit from it
 *
 * It gives the PresentationComponent to its children so they can inject dependencies.
 */
open class BaseActivity : AppCompatActivity() {

    private var isInjectorUsed: Boolean = false

    @UiThread
    protected fun getPresentationComponent(): PresentationComponent {
        if (isInjectorUsed) {
            throw RuntimeException("there is no need to use injector more than once")
        }
        isInjectorUsed = true
        return getApplicationComponent()
            .newPresentationComponent(PresentationModule())

    }

    private fun getApplicationComponent() = (application as MyApp).applicationComponent
}
