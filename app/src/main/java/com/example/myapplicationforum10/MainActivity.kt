package com.example.myapplicationforum10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.lifecycle.lifecycleScope
import com.example.myapplicationforum10.PostAdapter
import com.example.myapplicationforum10.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var fabAddPost: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user = User("StaticUser", R.drawable.profile_image)
        val postList = mutableListOf(
            Post("5","Title 1", "Content 1", R.drawable.image1, "2023-01-01", 10, 5, user),
            Post("6","Title 2", "Content 2", R.drawable.image2, "2023-01-02", 15, 8, user),
        )
        fabAddPost = findViewById(R.id.fabAddPost)

        fabAddPost.setOnClickListener {
            // Navigate to AddPostActivity when the button is clicked
            val intent = Intent(this, AddPostActivity::class.java)
            startActivity(intent)
        }

        val postAdapter = PostAdapter(this, postList)

        val postListView: ListView = findViewById(R.id.postListView)
        postListView.adapter = postAdapter

    }

}
