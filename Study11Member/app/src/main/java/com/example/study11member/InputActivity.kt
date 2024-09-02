package com.example.study11member

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.study11member.databinding.ActivityInputBinding

class InputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // setContentView(R.layout.activity_input)

        val binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 수정인지 추가인지 구분
        if(intent.getStringExtra("button").toString() == "add") { //추가
            binding.btnAdd.text = "ADD"
        } else { // update
            with(binding) {
                btnAdd.text = "UPDATE"
                edtName.setText(intent.getStringExtra("name"))
                edtPhone.setText(intent.getStringExtra("phone"))
                edtEmail.setText(intent.getStringExtra("email"))
            }

//            binding.btnAdd.text = "UPDATE"
//            binding.edtName.setText(intent.getStringExtra("name"))
//            binding.edtPhone.setText(intent.getStringExtra("phone"))
//            binding.edtEmail.setText(intent.getStringExtra("email"))
        }

        binding.btnAdd.setOnClickListener {
            if(binding.btnAdd.text == "UPDATE") { // 수정
                intent.putExtra("pos", intent.getIntExtra("pos", 0))
                intent.putExtra("button", "update")
            } else { // 추가
                intent.putExtra("button", "add")
            }

            intent.putExtra("name", binding.edtName.text.toString()?:"")
            intent.putExtra("phone", binding.edtPhone.text.toString()?:"")
            intent.putExtra("email", binding.edtEmail.text.toString()?:"")

            setResult(RESULT_OK, intent)
            finish()
        }
    }
}