package com.example.myapplicationforum10

data class Comment(
    val commentId: String,
    val postId: String,
    val author: String,
    val text: String,
    val timestamp: Long
)
