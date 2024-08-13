package com.example.study02

import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

// p145~146 : 직접 화면 구성
class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main2)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        // p145 => R.layout.activity_main2 이용하지 않고 화면 구성을 직접하기
        // 문자열 출력
        val name = TextView(this).apply {
            typeface = Typeface.DEFAULT_BOLD
            text = "text name"
        }

        // 이미지 출력
        val image = ImageView(this).also {
            it.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.call))
        }

        // 주소 문자열
        val address = TextView(this).apply {
            typeface = Typeface.DEFAULT_BOLD
            text = "text address ~~~~~"
        }

        // 레이아웃 => 배치 결정
        val layout = LinearLayout(this).apply { // LinearLayout : 놓여지는 순서대로 배치
            // 가로, 세로 정렬 방식
            orientation = LinearLayout.VERTICAL // 세로
            gravity = Gravity.CENTER /////////////////////확인하기

            // 이름, 이미지, 주소 순으로 배열
            addView(name, WRAP_CONTENT, WRAP_CONTENT)
            addView(image, WRAP_CONTENT, WRAP_CONTENT)
            addView(address, WRAP_CONTENT, WRAP_CONTENT)
        }

        // 화면에 출력
        setContentView(layout)
    }
}