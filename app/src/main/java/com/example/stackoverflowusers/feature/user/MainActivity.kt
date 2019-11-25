package com.example.stackoverflowusers.feature.user

import android.os.Bundle
import android.widget.FrameLayout
import androidx.lifecycle.ViewModelProviders
import com.example.stackoverflowusers.BaseActivity
import com.example.stackoverflowusers.R
import com.example.stackoverflowusers.core.viewmodel.ViewModelFactory
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        // Clients (in this case MainActivity) use Dagger component as injector to inject
        // services (dependencies) into themselves
        getPresentationComponent().inject(this)
        super.onCreate(savedInstanceState)
        // The ViewModel is initialised in the parent (activity) but will be shared by the children
        // as well. That's one of the beauty of the ViewModel, share data among an activity and its
        // children (fragments)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(UserViewModel::class.java)
        setContentView(R.layout.activity_main)

        startUserListFragment(savedInstanceState)
    }

    private fun startUserListFragment(savedInstanceState: Bundle?) {
        if (findViewById<FrameLayout>(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return
            }
            val userListFragment = UserListFragment()

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            userListFragment.arguments = intent.extras

            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, userListFragment).commit()
        }
    }
}
