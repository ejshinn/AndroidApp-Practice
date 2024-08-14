package com.example.study03

import android.content.Context
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.study03.databinding.ActivityMainBinding

// p222
class MainActivity : AppCompatActivity() { //, CompoundButton.OnCheckedChangeListener {
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

        // binding.checkBox1.setOnCheckedChangeListener(this)

        binding.checkBox2.setOnCheckedChangeListener(MyHandler(this@MainActivity))

        // 람다함수 : SAM 방식
        binding.checkBox3.setOnCheckedChangeListener { compoundButton, b ->
            Toast.makeText(this, "세 번째 체크박스 선택 람다함수 사용", Toast.LENGTH_LONG).show()
        }

        binding.button1.setOnClickListener {
            Toast.makeText(this, "button1 클릭", Toast.LENGTH_LONG).show()
        }

        binding.button2.setOnLongClickListener {
            Toast.makeText(this, "button2 롱클릭", Toast.LENGTH_LONG).show()
            true
        }
    }

//    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
//        Toast.makeText(this, "첫 번째 체크박스 선택 this 사용", Toast.LENGTH_LONG).show()
//    }

    class MyHandler(private val context: Context):CompoundButton.OnCheckedChangeListener {
        override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
            Toast.makeText(context, "두 번째 체크박스 선택 class 사용", Toast.LENGTH_LONG).show()
        }
    }
}