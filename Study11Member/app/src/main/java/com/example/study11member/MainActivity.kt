package com.example.study11member

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.study11member.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
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

        // 데이터 mutableListOf
        var memberList = mutableListOf<Member>()
        // 어댑터 생성
        val memberAdapter = MemberAdapter(memberList)
        // 리사이클러뷰와 어댑터 연결
        binding.recyclerView.adapter = memberAdapter
        // 레이아웃 설정
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        /// 전체보기
        MemberClient.retrofit.findAll().enqueue(object : retrofit2.Callback<List<Member>> {
            override fun onResponse(call: Call<List<Member>>, response: Response<List<Member>>) {
                memberAdapter.memberList = response.body() as MutableList<Member>
                memberAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<Member>>, t: Throwable) {
            }
        })

        ///
        val activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if(it.resultCode == RESULT_OK) {
                val button = it.data?.getStringExtra("button")
                val id = it.data?.getLongExtra("id", 0)?:0
                val pos = it.data?.getIntExtra("pos", 0)?:0

                val name = it.data?.getStringExtra("name")?:""
                val phone = it.data?.getStringExtra("phone")?:""
                val email = it.data?.getStringExtra("email")?:""

                var member = Member(id, name, phone, email)

                // 추가인지 수정인지 구분
                if(button == "add") { // 추가
                    MemberClient.retrofit.save(member).enqueue(object : retrofit2.Callback<Member> {
                        override fun onResponse(call: Call<Member>, response: Response<Member>) {
                            memberAdapter.addItem(response.body()!!)
                        }

                        override fun onFailure(call: Call<Member>, t: Throwable) {

                        }
                    })
                } else { // 수정
                    MemberClient.retrofit.update(id, member).enqueue(object :retrofit2.Callback<Member> {
                        override fun onResponse(call: Call<Member>, response: Response<Member>) {
                            memberAdapter.updateItem(member, pos!!)
                        }

                        override fun onFailure(call: Call<Member>, t: Throwable) {

                        }

                    })
                }
            }
        }

        // 추가 버튼 클릭
        binding.floatingButton.setOnClickListener {
            val intent = Intent(this, InputActivity::class.java)
            //startActivity(intent)
            intent.putExtra("button", "add")
            activityResultLauncher.launch(intent)
        }

        // 수정
        /// memberAdapter에 있는 클릭 이벤트 구현
        memberAdapter.onItemClickListener = object : MemberAdapter.OnItemClickListener {
            override fun onItemClick(member: Member, pos: Int) {
                // Membe를 수정하기 위해 기존 데이터를 intent에 보여줘야 함
                val member = memberAdapter.memberList[pos] // 수정할 member
                val intent = Intent(this@MainActivity, InputActivity::class.java)

                intent.putExtra("id", member.id)
                intent.putExtra("name", member.name)
                intent.putExtra("phone", member.phone)
                intent.putExtra("email", member.email)

                intent.putExtra("pos", pos)
                intent.putExtra("button","update") // button == add(추가)/update(수정)

                activityResultLauncher.launch(intent)
            }
        }
    }
}