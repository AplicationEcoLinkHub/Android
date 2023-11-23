package com.example.myapplicationforum10
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    @GET("posts/{postId}")
    suspend fun getPost(@Path("postId") postId: String): Post

    @POST("posts")
    suspend fun createPost(@Body post: Post): Post

    @PUT("posts/{postId}")
    suspend fun updatePost(@Path("postId") postId: String, @Body post: Post): Post

    @DELETE("posts/{postId}")
    suspend fun deletePost(@Path("postId") postId: String): Void
}


