package com.example.study04intent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.study04intent.databinding.Activity2AddBinding

class MainActivity2Add : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity2_add)

        val binding = Activity2AddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var num1 = intent.getIntExtra("num1", 0)
        var num2 = intent.getIntExtra("num2", 0)
        var sum = num1 + num2

        binding.btnResult.setOnClickListener {
            val intent1 = Intent(applicationContext, MainActivity::class.java)
            intent1.putExtra("sum", sum)
            setResult(RESULT_OK, intent1)
            finish()
        }
    }
}