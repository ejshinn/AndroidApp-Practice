package com.example.study05

import android.content.DialogInterface
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.study05.databinding.Activity5DialogBinding
import com.example.study05.databinding.Activity5PersonBinding

class MainActivity5Person : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main5)

        val binding = Activity5PersonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. 데이터 생성 => 전체보기 버튼 이벤트에서 구현
        var personList = mutableListOf<PersonItem>() // personList에 아무것도 없

        // 2. 어댑터 생성
        var personAdapter = PersonAdapter(personList)

        //3. 리사이클러뷰에 어댑터 연결
        binding.recyclerView.adapter = personAdapter

        // 4. 리사이클러뷰에 레이아웃 설정
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // 전체보기 클릭
        binding.button.setOnClickListener {
            personList.clear()

            for(i in 0 .. 4) {
                personList.add(PersonItem("홍길동$i", "010-1111-222$i"))
            }

            personAdapter.notifyDataSetChanged()
        }

        // 추가(+) 버튼 클릭
        binding.floatingActionButton.setOnClickListener {
            val dialogBinding = Activity5DialogBinding.inflate(layoutInflater)

            AlertDialog.Builder(this).run {
                setTitle("추가")
                setMessage("여기서 추가 내용을 입력하세요")
                setView(dialogBinding.root) // 커스텀으로 만든 화면

                setNegativeButton("취소", null)
                setPositiveButton("확인", object: DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        personList.add(PersonItem(dialogBinding.edtName.text.toString(), dialogBinding.edtPhone.text.toString()))
                        personAdapter.notifyDataSetChanged()
                    }
                })
                show()
            }
        }
    }
}