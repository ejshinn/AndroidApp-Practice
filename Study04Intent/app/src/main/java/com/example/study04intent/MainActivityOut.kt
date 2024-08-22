package com.example.study04intent

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.study04intent.databinding.ActivityOutBinding

class MainActivityOut : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_out)

        val binding = ActivityOutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 전달받은 intent에서 값을 추출하여 출력
        var name = intent.getStringExtra("name").toString()
        var age = intent.getStringExtra("age").toString()
        var phone = intent.getStringExtra("phone").toString()
        binding.txtResult.text = "이름 : ${name}, 나이 : ${age}, 전화번호 :  ${phone}"
    }


}