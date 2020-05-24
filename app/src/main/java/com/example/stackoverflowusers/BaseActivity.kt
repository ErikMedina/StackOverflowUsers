package com.example.stackoverflowusers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.stackoverflowusers.core.di.presentation.PresentationComponent

/**
 * Activity declared as open so other activities can inherit from it
 *
 * It gives the PresentationComponent to its children so they can inject dependencies.
 */
open class BaseActivity : AppCompatActivity() {

    private var isInjectorUsed: Boolean = false
    lateinit var presentationComponent: PresentationComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        // TODO: I might need a component which contains dependencies common to all activities
        presentationComponent =
            (application as MyApp).applicationComponent.presentationComponent().create(this)
        super.onCreate(savedInstanceState)
    }

    //    @UiThread
//    protected fun getPresentationComponent(): PresentationComponent {
//        if (isInjectorUsed) {
//            throw RuntimeException("there is no need to use injector more than once")
//        }
//        isInjectorUsed = true
//        return getApplicationComponent().newPresentationComponent(PresentationModule(this))
//    }

    private fun getApplicationComponent() = (application as MyApp).applicationComponent
}
