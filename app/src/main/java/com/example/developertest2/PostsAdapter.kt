package com.example.developertest2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.post_row.view.*

class PostsAdapter(

    private val posts: List<Post>,
    private val itemClickListener: OnRecyclerViewItemClickListener
) : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userId.text = "Userid:" + posts[position].userId.toString()
        //holder.id1.text = "id:" + posts[position].id.toString()
        holder.title.text = "Title:" + posts[position].title
        //holder.body.text = "Body:" + posts[position].body

        val context = holder.rootLayout.context
        if (position < 20) {
            holder.rootLayout.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.colorHighlitedPost
                )
            )
        } else {
            holder.rootLayout.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.colorNormalPost
                )
            )
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                itemClickListener.onItemClick(posts[adapterPosition])
            }
        }
        val rootLayout: ConstraintLayout = itemView.rootLayout
        val userId: TextView = itemView.userid
        //val id1: TextView = itemView.id1
        val title: TextView = itemView.title
        //val body: TextView = itemView.body
    }

}
