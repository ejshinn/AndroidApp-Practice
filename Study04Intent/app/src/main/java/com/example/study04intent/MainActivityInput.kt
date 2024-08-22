package com.example.study04intent

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.study04intent.databinding.ActivityInputBinding

class MainActivityInput : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_input)

        val binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnAdd.setOnClickListener {
            Log.d("name : ", "${binding.edtName.text}")
            intent.putExtra("name", binding.edtName.text.toString())
            intent.putExtra("age", binding.edtAge.text.toString())
            intent.putExtra("phone", binding.edtPhone.text.toString())
            setResult(RESULT_OK, intent)

            finish()
        }
    }
}