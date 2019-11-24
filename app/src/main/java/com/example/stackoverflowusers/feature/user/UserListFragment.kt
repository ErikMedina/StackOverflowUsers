package com.example.stackoverflowusers.feature.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.stackoverflowusers.R
import com.example.stackoverflowusers.core.viewmodel.Result

class UserListFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.let {
            // Shared ViewModel between Activity and Fragments
            userViewModel = ViewModelProviders.of(it).get(UserViewModel::class.java)
            userViewModel.result.observe(this,
                Observer<Result> { result -> processResponse(result) })
        }
    }

    private fun processResponse(result: Result) {

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        initializeRecycler()
        userViewModel.getUsers()
    }
}
