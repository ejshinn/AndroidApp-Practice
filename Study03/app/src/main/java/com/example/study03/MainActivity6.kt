package com.example.study03

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.study03.databinding.ActivityMain6Binding

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // setContentView(R.layout.activity_main6)

        val binding = ActivityMain6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Four 라디오 버튼 클릭
        binding.rdoFour.setOnClickListener {
            val intent = Intent(this@MainActivity6, FourActivity::class.java)
            startActivity(intent)
        }

        // Second, Third 라디오 버튼
        binding.btnNewActivity.setOnClickListener {
            var intent:Intent? = null

            if(binding.rdoSecond.isChecked) {
                intent = Intent(applicationContext, SecondActivity::class.java)
            }
            else if(binding.rdoThird.isChecked) {
                intent = Intent(applicationContext, ThirdActivity::class.java)
                intent.putExtra("name", "홍길동")
                intent.putExtra("key", "key값에 전달되는 value")
            }

            startActivity(intent)
        }
    }
}