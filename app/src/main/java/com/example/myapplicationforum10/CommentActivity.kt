package com.example.myapplicationforum10

// CommentActivity.kt
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CommentActivity : AppCompatActivity() {

    private lateinit var commentAdapter: CommentAdapter
    private lateinit var editTextComment: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        // Retrieve the post ID from the intent
        val postId = intent.getStringExtra("postId")

        // Set up RecyclerView for comments
        val recyclerViewComments: RecyclerView = findViewById(R.id.recyclerViewComments)
        recyclerViewComments.layoutManager = LinearLayoutManager(this)

        // Initialize the EditText without safe call
        editTextComment = findViewById(R.id.editTextComment)

        // Add a comment button click listener
        val buttonAddComment: Button = findViewById(R.id.buttonAddComment)
        buttonAddComment.setOnClickListener {
            // Get the comment text from the EditText
            val newCommentText: String = editTextComment.text.toString()

            // Dummy logic for testing, replace with your saveComment logic
            saveComment(postId, "user123", newCommentText, System.currentTimeMillis())
        }

        // Dummy data for testing, replace with your logic
        val commentList: List<Comment> = getCommentsForPost(postId)
        commentAdapter = CommentAdapter(commentList.toMutableList())
        recyclerViewComments.adapter = commentAdapter
    }

    // Dummy method for testing, replace with your getCommentsForPost logic
    private fun getCommentsForPost(postId: String?): List<Comment> {
        // Check if postId is null and handle it accordingly
        if (postId == null) {
            // Return an empty list or handle it based on your logic
            return emptyList()
        }

        // Implement logic to retrieve comments for the given postId
        // Replace this with your actual data retrieval logic
        return listOf(
            Comment("1", postId, "User1", "Comment 1", System.currentTimeMillis()),
            Comment("2", postId, "User2", "Comment 2", System.currentTimeMillis()),
            Comment("3", postId, "User3", "Comment 3", System.currentTimeMillis())
        )
    }

    // Dummy method for testing, replace with your saveComment logic
    private fun saveComment(postId: String?, author: String, commentText: String, timestamp: Long) {
        // Check if postId is null and handle it accordingly
        if (postId == null) {
            // Log an error, return, or handle it based on your logic
            return
        }

        // Implement logic to save the comment to the database or wherever you store comments
        // Replace this with your actual data saving logic
        // For testing, you can add the new comment to the list
        val newComment = Comment("4", postId, author, commentText, timestamp)
        commentAdapter.addComment(newComment)

        // Refresh the comment list
        val updatedCommentList: List<Comment> = getCommentsForPost(postId)
        commentAdapter.updateComments(updatedCommentList)

        // Clear the comment text in the EditText
        editTextComment.text.clear()
    }
}
