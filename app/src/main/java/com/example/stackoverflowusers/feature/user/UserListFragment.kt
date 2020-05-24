package com.example.stackoverflowusers.feature.user

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stackoverflowusers.BaseFragment
import com.example.stackoverflowusers.R
import com.example.stackoverflowusers.core.local.model.User
import com.example.stackoverflowusers.core.viewmodel.Error
import com.example.stackoverflowusers.core.viewmodel.Error.Type.GENERAL_ERROR
import com.example.stackoverflowusers.core.viewmodel.Error.Type.NO_USERS
import com.example.stackoverflowusers.core.viewmodel.Result
import com.example.stackoverflowusers.core.viewmodel.Status
import com.example.stackoverflowusers.feature.user.adapter.UserAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_user_list.*
import javax.inject.Inject

class UserListFragment : BaseFragment() {

//    @Inject TODO: let's see if we can inject FragmentActivity
//    lateinit var fragmentActivity: FragmentActivity

    @Inject
    lateinit var adapter: UserAdapter

//    @Inject TODO: navigator needs activity context
//    lateinit var navigator: Navigator

    private lateinit var viewModel: UserViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (activity as MainActivity).presentationComponent.inject(this)
//        getPresentationComponent().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Shared ViewModel between Activity and Fragments
        viewModel = ViewModelProviders.of(requireActivity()).get(UserViewModel::class.java)
        viewModel.result.observe(this,
            Observer<Result> { result -> processResponse(result) })
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

        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(requireActivity())
        adapter.userListener = {
            viewModel.user = it
//            navigator.startPostDetailFragment()
        }

        viewModel.getUsers()
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

    private fun renderErrorState(error: Error?) {
        when (error?.type) {
            GENERAL_ERROR -> error.message = R.string.error_general
            NO_USERS -> error.message = R.string.error_no_users
        }
        Log.e(TAG, error.toString())
        progressBar.visibility = View.GONE
        Snackbar.make(requireView(), error!!.message, Snackbar.LENGTH_LONG).show()
    }

    companion object {
        private const val TAG = "UserListFragment"
    }
}
