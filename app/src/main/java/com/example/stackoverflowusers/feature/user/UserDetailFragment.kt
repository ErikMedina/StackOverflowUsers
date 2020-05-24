package com.example.stackoverflowusers.feature.user

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.example.stackoverflowusers.BaseFragment
import com.example.stackoverflowusers.R
import com.example.stackoverflowusers.core.image.ImageLoader
import kotlinx.android.synthetic.main.fragment_user_detail.*
import javax.inject.Inject

class UserDetailFragment : BaseFragment() {

    @Inject
    lateinit var fragmentActivity: FragmentActivity

    @Inject
    lateinit var imageLoader: ImageLoader

    private lateinit var viewModel: UserViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        getPresentationComponent().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Shared ViewModel between Activity and Fragments
        viewModel = ViewModelProviders.of(fragmentActivity).get(UserViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        processUser()
    }

    private fun processUser() {
        viewModel.user?.run {
            imageLoader.loadThumbnail(ivProfile, profileImage)
            tvName.text = displayName
            tvUserId.text = userId.toString()
            tvReputation.text = reputation.toString()
        }
    }
}
