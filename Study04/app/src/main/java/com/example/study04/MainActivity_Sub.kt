package com.example.study04

import android.os.Bundle
import android.util.Log
import android.widget.RatingBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.study04.databinding.ActivitySubBinding

class MainActivity_Sub : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_sub)

        val binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // val intent = intent // 안 써도 됨
        val voteResult = intent.getIntArrayExtra("countVote")
        val imageResult = intent.getStringArrayExtra("imageName") // 이미지 이름 배열
        Log.d("voteResult : ", "${voteResult.toString()} /// ${imageResult.toString()}")

        val imageField = arrayOf<Int>(
            R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
            R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
            R.drawable.pic7, R.drawable.pic8, R.drawable.pic9
        )

        // 1등 찾기
        var maxPos = 0 // 최대 위치
        if (voteResult != null) {
            for(i in voteResult.indices) { // 배열 위치값
                if(voteResult[i] > voteResult[maxPos])
                    maxPos = i
            }
        }
        Log.d("maxPos : ", "${maxPos}")

        binding.tvTop.text = "${imageResult!![maxPos]}" // !! : 반드시 null이 아님 
        binding.ivTop.setImageResource(imageField[maxPos]) // setImageResource(Int형)

        // RatingBar 배열 선언
        val rbarId = arrayOf<RatingBar> (
            binding.rbar1, binding.rbar2, binding.rbar3,
            binding.rbar4, binding.rbar5, binding.rbar6,
            binding.rbar7, binding.rbar8, binding.rbar9
        )

        // 초기화 작업 구현하지 않음
        // RatingBar 표시
        for (i in 0 .. imageResult.size-1) {
            rbarId.get(i).rating = voteResult!![i].toFloat()
        }

        // 돌아가기 버튼
        binding.btnReturn.setOnClickListener {
            finish()
        }
    }
}