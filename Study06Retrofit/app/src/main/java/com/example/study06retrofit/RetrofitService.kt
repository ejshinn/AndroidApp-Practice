package com.example.study06retrofit

import com.example.study06retrofit.comment.CommentVO
import com.example.study06retrofit.photo.Photo
import com.example.study06retrofit.post.Post
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("photos/")
    fun doGetPhotos() : Call<List<Photo>>

    @GET("posts/")
    fun doGetPosts() : Call<List<Post>>

    @GET("comments/")
    fun doGetComments() : Call<List<CommentVO>>
}