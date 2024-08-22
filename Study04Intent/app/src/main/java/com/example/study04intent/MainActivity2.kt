package com.example.study04intent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.study04intent.databinding.ActivityMain2Binding

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

        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if(it.resultCode == RESULT_OK) {
                var sum = it.data?.getIntExtra("sum", 0)
                Toast.makeText(this@MainActivity2, "합계 : $sum", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnAdd.setOnClickListener {
            val intent = Intent(this@MainActivity2, MainActivity2Add::class.java)
            intent.putExtra("num1", binding.edtNum1.text.toString().toInt())
            intent.putExtra("num2", binding.edtNum2.text.toString().toInt())
            launcher.launch(intent)
        }
    }
}