package com.example.study06_1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.study06_1.databinding.ActivityMainBinding

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

        //1. 데이터 생성
        var friendList = mutableListOf<Friend>()

        // 데이터 생성
        for(i in 1..10){
            friendList.add(Friend("${i}번째 사람", "${i}번째 메시지", R.drawable.ic_launcher))
        }

        // 2. 어댑터 생성
        val friendAdapter = FriendAdapter(friendList)

        // 3. 리사이클러뷰와 어댑터 연결
        binding.recyclerView.adapter = friendAdapter

        // 4.리사이클러뷰에 레이아웃 설정
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}