package com.example.firebaseforum.ui.forums

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.firebaseforum.databinding.RoomPostBinding


class RoomRecyclerViewAdapter
    : ListAdapter<Post, RoomRecyclerViewAdapter.ViewHolder>(Comparator) {
    // An object used to determine if two items represent the same Post object
    object Comparator : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem === newItem
        }

        // An object used to determine if two items have the same contents
        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.timestamp == newItem.timestamp
        }
    }

    // Creates a new ViewHolder object for displaying items in the RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the view using the ForumPostBinding object
        return ViewHolder(
            RoomPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    // Binds a Post object to a ViewHolder object
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the Post object at the specified position in the list of items
        val item = getItem(position)

    }

    // A ViewHolder object for displaying a single Post object
    inner class ViewHolder(binding: RoomPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        // Views in the ViewHolder object
        private val postText: TextView = binding.post
        private val postAuthor: TextView = binding.forumPostAuthor
        private val postDate: TextView = binding.date
        private val decoration: View = binding.decoration


        // Returns a string representation of the ViewHolder object
        override fun toString(): String {
            return super.toString() + " '" + (postText.text) + "'"
        }
    }
}
