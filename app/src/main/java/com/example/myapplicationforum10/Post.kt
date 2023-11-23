package com.example.myapplicationforum10

// Post.kt
data class Post(
    val id: String,
    val title: String,
    val content: String,
    val imageUrl: Int,
    val datePublication: String,
    var likeCount: Int,
    val commentCount: Int,
    val user: User,
    var isLiked: Boolean = false  // Added isLiked property
)
