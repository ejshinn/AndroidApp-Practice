package com.example.study02

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.button1).setOnClickListener{
            Toast.makeText(this, "버튼1 클릭", Toast.LENGTH_SHORT).show()
            Log.d("button1", "button1 click")
        }

        findViewById<Button>(R.id.button2).setOnClickListener{
            Toast.makeText(this, "버튼2 클릭", Toast.LENGTH_SHORT).show()
            Log.d("button2", "button2 click")
        }
    }
}