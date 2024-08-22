package com.example.study05

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.study05.databinding.Activity4MovieBinding

class MainActivity4Movie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity4_movie)

        val binding = Activity4MovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var posterId = arrayOf<Int>(
            R.drawable.mov01, R.drawable.mov02,
            R.drawable.mov03, R.drawable.mov04,
            R.drawable.mov05, R.drawable.mov06,
            R.drawable.mov07, R.drawable.mov08,
            R.drawable.mov09, R.drawable.mov10
        )

        // 1. 데이터 생성
        var movieList = mutableListOf<MovieItem>()
        for(i in posterId.indices) { // 위치값
            // Log.d("posterId i : ", "${i}")
            val movie = MovieItem(posterId[i], "타이틀${i}")
            movieList.add(movie)
        }

        // 2. 어댑터
        val movieAdapter = MovieAdapter(movieList)
        
        // 3. recyclerView에 어댑터 연결
        binding.recyclerView.adapter = movieAdapter

        // 4. recyclerView의 layout 설정
        //binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = GridLayoutManager(this, 3)
    }
}