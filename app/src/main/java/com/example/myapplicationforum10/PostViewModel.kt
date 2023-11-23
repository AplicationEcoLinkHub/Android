package com.example.myapplicationforum10

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PostViewModel(private val apiService: ApiService) : ViewModel() {

    fun getPost(postId: String) {
        viewModelScope.launch {
            try {
                val post = apiService.getPost(postId)
                // Handle the retrieved post
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }

    fun createPost(post: Post) {
        viewModelScope.launch {
            try {
                val createdPost = apiService.createPost(post)
                // Handle the created post
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }

    fun updatePost(postId: String, post: Post) {
        viewModelScope.launch {
            try {
                val updatedPost = apiService.updatePost(postId, post)
                // Handle the updated post
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }

    fun deletePost(postId: String) {
        viewModelScope.launch {
            try {
                apiService.deletePost(postId)
                // Handle the deletion
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }
}
