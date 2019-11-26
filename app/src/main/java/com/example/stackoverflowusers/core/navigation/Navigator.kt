package com.example.stackoverflowusers.core.navigation

import androidx.fragment.app.FragmentActivity
import com.example.stackoverflowusers.R
import com.example.stackoverflowusers.feature.user.UserDetailFragment
import javax.inject.Inject

class Navigator @Inject constructor(private val fragmentActivity: FragmentActivity) {

    fun startPostDetailFragment() {
        // Create fragment and give it an argument specifying the article it should show
        val postDetailFragment = UserDetailFragment()
        val transaction = fragmentActivity.supportFragmentManager.beginTransaction().apply {
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            replace(R.id.fragment_container, postDetailFragment)
            addToBackStack(null)
        }
        transaction.commit()
    }
}
