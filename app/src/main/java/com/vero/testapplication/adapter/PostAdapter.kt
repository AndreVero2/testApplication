package com.vero.testapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vero.testapplication.R
import com.vero.testapplication.entities.Post
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_post.*

class PostAdapter(var items: List<Post>) : RecyclerView.Adapter<PostAdapter.PostHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = PostHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false))

    override fun getItemCount() = if (items.isEmpty()) 0 else Integer.MAX_VALUE

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.bind(items[position % items.size])
    }

    inner class PostHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(item: Post) {
            postId.text = item.id.toString()
            postTitle.text = item.title
            postBody.text = item.body
        }
    }
}