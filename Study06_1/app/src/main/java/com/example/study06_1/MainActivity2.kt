package com.example.study06_1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.study06_1.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main2)

        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //1. 데이터 생성
        var friendList2 = mutableListOf<Friend>()

        // 데이터 생성
        for(i in 1..10){
            friendList2.add(Friend("${i}번째 사람", "${i}번째 메시지", R.drawable.ic_launcher))
        }

        // 2. 어댑터 생성
        val friendAdapter2 = FriendAdapter2(friendList2)

        // 3. 리사이클러뷰와 어댑터 연결
        binding.recyclerView.adapter = friendAdapter2

        // 4.리사이클러뷰에 레이아웃 설정
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // 클릭 이벤트
        friendAdapter2.onItemClickListener = object : FriendAdapter2.OnItemClickListener {
            override fun onItemClick(position: Int) {
                Toast.makeText(application, "onItemClickListener : ${position + 1}", Toast.LENGTH_SHORT).show()
            }
        }

        // 롱클릭 이벤트
        friendAdapter2.onItemLongClickListener = object : FriendAdapter2.OnItemLongClickListener {
            override fun onItemLongClick(position: Int) {
                friendList2.removeAt(position)
                friendAdapter2.notifyDataSetChanged()
            }
        }
    }
}