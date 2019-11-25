package com.example.stackoverflowusers.feature.user.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.stackoverflowusers.R
import com.example.stackoverflowusers.core.local.model.User

class UserAdapter(private val context: Context, private val listener: OnUserClickListener) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    interface OnUserClickListener {
        fun onUserClick(user: User)
    }

    private var userViews = emptyList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = userViews.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.profile.text = userViews[position].userId.toString()
        holder.name.text = userViews[position].displayName
        holder.userId.text = userViews[position].userId.toString()
        holder.bind(userViews[position], listener)
    }

    fun setUserViews(users: List<User>) {
        this.userViews = users
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var profile: ImageView = itemView.findViewById(R.id.ivProfile)
        var name: TextView = itemView.findViewById(R.id.tvName)
        var userId: TextView = itemView.findViewById(R.id.tvUserId)

        fun bind(user: User, listener: OnUserClickListener) {
            itemView.setOnClickListener {
                listener.onUserClick(user)
            }
            loadThumbnail(user.profileImage)
        }

        private fun loadThumbnail(url: String) {
            Glide.with(context)
                .load(url)
                .placeholder(R.drawable.ic_launcher_background)
                .into(profile)
        }
    }
}
