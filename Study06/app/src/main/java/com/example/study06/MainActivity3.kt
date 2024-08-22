package com.example.study06

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.study06.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // setContentView(R.layout.activity_main3)

        val binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //1. 데이터 생성
        var personList = mutableListOf<Person3>()

        for(i in 0..4){
            personList.add(Person3("이름$i", "010-9999-888$i"))
        }

        // 2. 어댑터 생성
        val personAdapter3 = PersonAdapter3(personList)

        // 3. 리사이클러뷰와 어댑터 연결
        binding.recyclerView.adapter = personAdapter3

        // 4.리사이클러뷰에 레이아웃 설정
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        var position : Int = 0

        // 어댑터에 있는 리스너 호출
        personAdapter3.onItemClickListener = object : PersonAdapter3.OnItemClickListener {
            override fun onItemClick(pos: Int) {
                position = pos
                binding.edtName.setText(personList[pos].name)
                binding.edtPhone.setText(personList[pos].phone)

                binding.btnUpdate.isEnabled = true
                binding.btnDelete.isEnabled = true
                Toast.makeText(application, "OnItemClickListener pos : $pos", Toast.LENGTH_SHORT).show()
            }
        }

        // 추가버튼
        binding.btnInsert.setOnClickListener {
//            personList.add(Person3(binding.edtName.text.toString(),
//                binding.edtPhone.text.toString()))
//
//            personAdapter3.notifyDataSetChanged()
//
//            binding.edtName.setText("")
//            binding.edtPhone.setText("")

            val person = Person3(binding.edtName.text.toString(), binding.edtPhone.text.toString())
            personAdapter3.addItem(person)

            binding.edtName.setText("")
            binding.edtPhone.setText("")
        }

        // 수정 버튼
        binding.btnUpdate.setOnClickListener {
            val personDTO = Person3(binding.edtName.text.toString(), binding.edtPhone.text.toString())
            personAdapter3.updateItem(personDTO, position)

            binding.edtName.setText("")
            binding.edtPhone.setText("")

            binding.btnUpdate.isEnabled = false
            binding.btnDelete.isEnabled = false
        }

        // 삭제 버튼
        binding.btnDelete.setOnClickListener {
            personAdapter3.removeItem(position)

            binding.edtName.setText("")
            binding.edtPhone.setText("")

            binding.btnUpdate.isEnabled = false
            binding.btnDelete.isEnabled = false
        }
    }
}