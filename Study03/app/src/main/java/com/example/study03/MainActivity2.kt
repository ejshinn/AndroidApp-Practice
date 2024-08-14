package com.example.study03

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.study03.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // setContentView(R.layout.activity_main2)

        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 체크박스 선택
        binding.chkAgree.setOnCheckedChangeListener { compoundButton, isChecked ->
            if(isChecked) { // 체크
                binding.text2.visibility = View.VISIBLE
                binding.rgGroup.visibility = View.VISIBLE
                binding.btnOk.visibility = View.VISIBLE
                binding.imgPet.visibility = View.VISIBLE
            }
            else { // 체크 해제
                binding.text2.visibility = View.INVISIBLE
                binding.rgGroup.visibility = View.INVISIBLE
                binding.btnOk.visibility = View.INVISIBLE
                binding.imgPet.visibility = View.INVISIBLE
            }
        }

        // 선택완료 버튼 클릭
        binding.btnOk.setOnClickListener {
            //Log.d("checkedRadioButtonId : ", binding.rgGroup.checkedRadioButtonId.toString())

            // 고양이 라디오버튼 체크
//            if(binding.rgGroup.checkedRadioButtonId == R.id.rdoCat) {
//                binding.imgPet.setImageResource(R.drawable.cat)
//            }
            // 토끼 라디오버튼 체크
//            else if(binding.rgGroup.checkedRadioButtonId == R.id.rdoRabbit) {
//                binding.imgPet.setImageResource(R.drawable.rabbit)
//            }
            // 강아지 라디오버튼 체크
//            else if(binding.rgGroup.checkedRadioButtonId == R.id.rdoDog) {
//                binding.imgPet.setImageResource(R.drawable.dog)
//            }
//            else {
//                Toast.makeText(this, "동물을 선택하세요", Toast.LENGTH_SHORT).show()
//            }

            when(binding.rgGroup.checkedRadioButtonId) {
                R.id.rdoCat->binding.imgPet.setImageResource(R.drawable.cat)
                R.id.rdoRabbit->binding.imgPet.setImageResource(R.drawable.rabbit)
                R.id.rdoDog->binding.imgPet.setImageResource(R.drawable.dog)
                else->Toast.makeText(this, "동물을 선택하세요", Toast.LENGTH_SHORT).show()
            }
        }
    }
}