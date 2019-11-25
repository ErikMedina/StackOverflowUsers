package com.example.stackoverflowusers.feature.user

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stackoverflowusers.BaseFragment
import com.example.stackoverflowusers.R
import com.example.stackoverflowusers.core.local.model.User
import com.example.stackoverflowusers.core.viewmodel.Result
import com.example.stackoverflowusers.core.viewmodel.Status
import com.example.stackoverflowusers.feature.user.adapter.UserAdapter
import kotlinx.android.synthetic.main.fragment_user_list.*

class UserListFragment : BaseFragment() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        getPresentationComponent().inject(this)
        super.onCreate(savedInstanceState)

        activity?.let {
            // Shared ViewModel between Activity and Fragments
            userViewModel = ViewModelProviders.of(it).get(UserViewModel::class.java)
            userViewModel.result.observe(this,
                Observer<Result> { result -> processResponse(result) })
        }
    }

    private fun processResponse(result: Result) {
        when (result.status) {
            Status.LOADING -> renderLoadingState()

            Status.SUCCESS -> renderDataState(result.data)

            Status.ERROR -> renderErrorState(result.error)
        }
    }

    private fun renderLoadingState() {
        progressBar.visibility = View.VISIBLE
    }

    private fun renderDataState(users: List<User>) {
        progressBar.visibility = View.GONE
        adapter.setUserViews(users)
    }

    private fun renderErrorState(throwable: Throwable?) {
        Log.e(TAG, throwable.toString())
        progressBar.visibility = View.GONE
        Toast.makeText(
            activity,
            R.string.error_general,
            Toast.LENGTH_SHORT
        ).show()
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

        initializeRecycler()
        userViewModel.getUsers()
    }

    private fun initializeRecycler() {
        activity?.let {// TODO: inject activity
            adapter = UserAdapter(it, object : UserAdapter.OnUserClickListener {
                override fun onUserClick(user: User) {
                    Log.d(TAG, "[onUserClick] user selected: ${user.displayName}")
//                postsViewModel.post = post
//                (activity as PostsActivity).startPostDetailFragment()
                }
            })
            recycler.adapter = adapter
            recycler.layoutManager = LinearLayoutManager(activity)
        }
    }

    companion object {
        private const val TAG = "UserListFragment"
    }
}
