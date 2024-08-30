package com.example.study09db1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.study09db1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var currentPosition: Int? = null

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

        var helper = SqliteHelper(this, "memo", 1)

        // 어댑터 생성
        val adapter = RecyclerAdapter()
        adapter.helper = helper

        adapter.listData.addAll(helper.selectMemo()) // 전체보기 select * from memo
        binding.recyclerMemo.adapter = adapter
        binding.recyclerMemo.layoutManager = LinearLayoutManager(this)

        // 저장 버튼 클릭
//        binding.buttonSave.setOnClickListener {
//            if(binding.editMemo.text.toString().isNotEmpty()) {
//                val memo = Memo(null, binding.editMemo.text.toString(),
//                    System.currentTimeMillis())
//
//                // insert 작업
//                helper.insertMemo(memo)
//
//                adapter.listData.clear()
//                adapter.listData.addAll(helper.selectMemo())
//                adapter.notifyDataSetChanged()
//
//                binding.editMemo.setText("")
//            }
//        }

        // 저장 버튼 클릭
        binding.buttonSave.setOnClickListener {
            if (binding.editMemo.text.toString().isNotEmpty()) {
                if (currentPosition != null) {
                    // 수정 모드
                    val pos = currentPosition!!
                    val memo = adapter.listData[pos].apply {
                        content = binding.editMemo.text.toString()
                    }
                    helper.updateMemo(memo)
                    adapter.listData[pos] = memo
                    adapter.notifyDataSetChanged()

                    binding.editMemo.setText("")
                    binding.buttonSave.text = "저장"
                    currentPosition = null
                } else {
                    // 새로운 메모 추가
                    val memo = Memo(null, binding.editMemo.text.toString(), System.currentTimeMillis())
                    helper.insertMemo(memo)

                    adapter.listData.clear()
                    adapter.listData.addAll(helper.selectMemo())
                    adapter.notifyDataSetChanged()

                    binding.editMemo.setText("")
                }
            }
        }

        // 항목 클릭 리스너 설정
        adapter.onItemClickLister = object : RecyclerAdapter.OnItemClickLister {
            override fun onItemClick(pos: Int) {
                currentPosition = pos
                binding.editMemo.setText(adapter.listData[pos].content)

                binding.buttonSave.text = "수정"
            }
        }
    }
}