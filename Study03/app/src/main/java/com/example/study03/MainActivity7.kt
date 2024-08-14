package com.example.study03

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.study03.databinding.ActivityMain7Binding

class MainActivity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main7)

        val binding = ActivityMain7Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 시작 switch 클릭
        binding.switchAgree.setOnCheckedChangeListener { compoundButton, isChecked ->
            if(isChecked) { // 체크
                binding.text2.visibility = View.VISIBLE
                binding.rgGroup.visibility = View.VISIBLE
                binding.imgPet.visibility = View.VISIBLE
                binding.btnQuit.visibility = View.VISIBLE
                binding.btnReturn.visibility = View.VISIBLE
            }
            else { // 체크 해제
                binding.text2.visibility = View.INVISIBLE
                binding.rgGroup.visibility = View.INVISIBLE
                binding.imgPet.visibility = View.INVISIBLE
                binding.btnQuit.visibility = View.INVISIBLE
                binding.btnReturn.visibility = View.INVISIBLE
            }
        }

        // 종료 버튼 클릭
        binding.btnQuit.setOnClickListener {
            finish()
        }

        // 처음으로 버튼 클릭
        binding.btnReturn.setOnClickListener {
            binding.rgGroup.clearCheck()
            binding.switchAgree.isChecked = false
        }

        val radioArray:Array<RadioButton> = arrayOf(binding.rdoCat, binding.rdoRabbit, binding.rdoDog)
        val imgArray:Array<Int> = arrayOf(R.drawable.cat, R.drawable.rabbit, R.drawable.dog)

        // 라디오 이벤트
        for((index, rdo) in radioArray.withIndex()) { // withIndex() => 순서, 객체 정보
            Log.d("radioArray rdo : ", rdo.toString())

            rdo.setOnClickListener { // rdo =>라디오 버튼 클릭
                binding.imgPet.setImageResource(imgArray[index])

                var intent: Intent? = null

                intent = Intent(applicationContext, PetActivity::class.java)
                intent.putExtra("name", rdo.text)

                startActivity(intent)
            }
        }
    }
}