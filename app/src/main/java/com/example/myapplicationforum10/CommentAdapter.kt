package com.example.myapplicationforum10

// CommentAdapter.kt
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationforum10.R

class CommentAdapter(private val comments: MutableList<Comment>) : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comment, parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = comments[position]
        holder.bind(comment)
    }

    override fun getItemCount(): Int {
        return comments.size
    }

    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val authorTextView: TextView = itemView.findViewById(R.id.authorTextView)
        private val commentTextView: TextView = itemView.findViewById(R.id.commentTextView)

        fun bind(comment: Comment) {
            authorTextView.text = comment.author
            commentTextView.text = comment.text
        }
    }

    fun updateComments(newComments: List<Comment>) {
        comments.clear()
        comments.addAll(newComments)
        notifyDataSetChanged()
    }
    fun addComment(newComment: Comment) {
        comments.add(newComment)
        notifyItemInserted(comments.size - 1)
    }
}
