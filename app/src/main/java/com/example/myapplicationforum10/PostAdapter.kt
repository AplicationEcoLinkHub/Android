package com.example.myapplicationforum10

// PostAdapter.kt
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.myapplicationforum10.databinding.ListItemPostBinding
import com.example.myapplicationforum10.R

class PostAdapter(context: Context, posts: List<Post>) :
    ArrayAdapter<Post>(context, 0, posts) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val post = getItem(position)
        val binding: ListItemPostBinding

        if (convertView == null) {
            val inflater = LayoutInflater.from(context)
            binding = ListItemPostBinding.inflate(inflater, parent, false)
            binding.root.tag = binding
        } else {
            binding = convertView.tag as ListItemPostBinding
        }

        // Set data to the views using the binding object
        binding.postImage.setImageResource(post?.imageUrl ?: R.drawable.placeholder_image)
        binding.postTitle.text = post?.title
        binding.postContent.text = post?.content
        binding.likeCount.text = "${post?.likeCount} Likes"
        binding.commentCount.text = "${post?.commentCount} Comments"
        val likeButton = binding.likeButton
        likeButton.setImageResource(if (post?.isLiked == true) R.drawable.heart_filled else R.drawable.heart_outline)
        likeButton.setOnClickListener {
            // Toggle the like status
            post?.isLiked = !(post?.isLiked ?: false)

            // Update the like count
            post?.likeCount = if (post?.isLiked == true) (post?.likeCount ?: 0) + 1 else (post?.likeCount ?: 0) - 1
            binding.likeCount.text = "${post?.likeCount} Likes"

            // Update the like button drawable
            likeButton.setImageResource(if (post?.isLiked == true) R.drawable.heart_filled else R.drawable.heart_outline)
        }
        val commentButton = binding.commentButton
        commentButton.setOnClickListener {
            // Implement your logic to handle the comment button click
            // You can open a comment activity, show a dialog, etc.
            // Example: Open a CommentActivity with the post ID
            val intent = Intent(context, CommentActivity::class.java)
            intent.putExtra("postId", post?.id)  // Add any necessary data to identify the post
            context.startActivity(intent)
        }

        return binding.root



    }

}
