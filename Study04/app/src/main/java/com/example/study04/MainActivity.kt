package com.example.study04

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.study04.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // 투표수 저장 배열
        val countVote = IntArray(9)

        // 이미지 저장 배열
        val imageId = arrayOf<ImageView>(
            binding.iv1, binding.iv2, binding.iv3,
            binding.iv4, binding.iv5, binding.iv6,
            binding.iv7, binding.iv8, binding.iv9,
        )

        // 이미지 이름 저장 배열
        val imageName = arrayOf(
            "pic1", "pic2", "pic3",
            "pic4", "pic5", "pic6",
            "pic7", "pic8", "pic9"
        )

        // 이미지뷰 클릭 이벤트 처리
        for ((idx, imgValue) in imageId.withIndex()) { // withIndex => 위치(idx), 객체(imgValue)
            imgValue.setOnClickListener {
                countVote[idx]++ // 투표수 1 증가
                Log.d("countVote : ", countVote[idx].toString())
                Log.d("image View : ", imgValue.toString())
                Toast.makeText(this, "${imageName[idx]} 총 ${countVote[idx]}표", Toast.LENGTH_SHORT).show()
            }
        }

        // 투표 종료 버튼
        // this@MainActivity 대신 this만 써도 됨
        binding.btnResult.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity_Sub::class.java)

            // 투표수
            // 우승 그림 이미지
            intent.putExtra("countVote", countVote) // countVote 키에 countVote 배열
            intent.putExtra("imageName", imageName) // imageName 키에 imageName 배열


            startActivity(intent)
        }
    }
}