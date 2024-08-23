package com.example.study06retrofit

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.study06retrofit.comment.CommentVO
import com.example.study06retrofit.comment.CommentAdapter
import com.example.study06retrofit.databinding.ActivityMainBinding
import com.example.study06retrofit.photo.Photo
import com.example.study06retrofit.photo.PhotoAdapter
import com.example.study06retrofit.post.Post
import com.example.study06retrofit.post.PostAdapter
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 리사이클러뷰에 레이아웃 설정
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Photo Button 클릭
        binding.btnPhoto.setOnClickListener {
            // 1. 데이터 mutableListOf 생성
            var photoList = mutableListOf<Photo>()

            // 2. 어댑터 생성
            var photoAdapter = PhotoAdapter(photoList)

            // 3. 리사이클러뷰와 어댑터 연결
            binding.recyclerView.adapter = photoAdapter

            // https://jsonplaceholder.typicode.com/photos/
            RetrofitClient.photoRetrofit.doGetPhotos().enqueue(object:retrofit2.Callback<List<Photo>> {
                override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                    if(response.isSuccessful) { // 성공
                        Log.d("onResponse : ", "${response.body()}")

                        for(photo in response.body()!!) {
                            photoList.add(photo)
                        }
                        photoAdapter.notifyDataSetChanged()
                    }
                }

                // 실패
                override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                    Log.d("onFailure : ", t.localizedMessage)
                }
            })
        }

        // Post Button 클릭
        binding.btnPost.setOnClickListener {
            // 1. 데이터 mutableListOf 생성
            var postList = mutableListOf<Post>()

            // 2. 어댑터 생성
            var postAdapter = PostAdapter(postList)

            // 3. 리사이클러뷰와 어댑터 연결
            binding.recyclerView.adapter = postAdapter

            // https://jsonplaceholder.typicode.com/posts/
            RetrofitClient.postRetrofit.doGetPosts().enqueue(object:retrofit2.Callback<List<Post>> {
                override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    if(response.isSuccessful) { // 성공
                        for(post in response.body()!!) {
                            postList.add(post)
                        }
                        postAdapter.notifyDataSetChanged()
                    }
                }

                // 실패
                override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                    Log.d("onFailure : ", t.localizedMessage)
                }
            })
        }

        // Comment Button 클릭
        binding.btnComment.setOnClickListener {
            // 1. 데이터 mutableListOf 생성
            var commentList = mutableListOf<CommentVO>()

            // 2. 어댑터 생성
            var commentAdapter = CommentAdapter(commentList)

            // 3. 리사이클러뷰와 어댑터 연결
            binding.recyclerView.adapter = commentAdapter

            // https://jsonplaceholder.typicode.com/comments/
            RetrofitClient.commentRetrofit.doGetComments().enqueue(object:retrofit2.Callback<List<CommentVO>> {
                override fun onResponse(call: Call<List<CommentVO>>, response: Response<List<CommentVO>>) {
                    if(response.isSuccessful) { // 성공
                        for(comment in response.body()!!) {
                            commentList.add(comment)
                        }
                        commentAdapter.notifyDataSetChanged()
                    }
                }

                // 실패
                override fun onFailure(call: Call<List<CommentVO>>, t: Throwable) {
                    Log.d("onFailure : ", t.localizedMessage)
                }
            })
        }
    }
}