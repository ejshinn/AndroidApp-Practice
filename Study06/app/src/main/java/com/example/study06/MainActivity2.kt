package com.example.study06

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.study06.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // setContentView(R.layout.activity_main2)

        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //1. 데이터 생성
        var personList = mutableListOf<Person2>() // personList에 아무것도 없음

        // 2. 어댑터 생성
        val personAdapter2 = PersonAdapter2(personList)

        // 3. 리사이클러뷰와 어댑터 연결
        binding.recyclerView.adapter = personAdapter2

        // 4.리사이클러뷰에 레이아웃 설정
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // 전체보기 버튼 클릭
        binding.btnList.setOnClickListener {
            personList.clear()

            for(i in 0..6){
                personList.add(Person2("이름$i", "010-0000-777$i"))
            }

            personAdapter2.notifyDataSetChanged()
        }

        val activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if(it.resultCode == RESULT_OK) {
                val name = it.data?.getStringExtra("name").toString() ?: ""
                val phone = it.data?.getStringExtra("phone").toString() ?: ""
                personList.add(Person2(name, phone))
                personAdapter2.notifyDataSetChanged()
            }
        }

        // + 추가 버튼 클릭
        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this@MainActivity2, MainActivity2Sub::class.java)
            // startActivity(intent) // 리턴값 없을 때
            activityResultLauncher.launch(intent) // 리턴값 있을 때
        }
    }
}