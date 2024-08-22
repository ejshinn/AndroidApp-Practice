package com.example.study04intent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.study04intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var name:String?= null
        var age:String?= null
        var phone:String?= null

        // intent로부터 리턴값 처리
        // 매개변수 마지막이 람다 함수 형식이면 소괄호 밖으로 뺄 수 있음
        val activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

            if(it.resultCode == RESULT_OK) {
                // ? : 엘비스 표현식
                name = it.data?.getStringExtra("name").toString() ?: ""
                age = it.data?.getStringExtra("age").toString() ?: ""
                phone = it.data?.getStringExtra("phone").toString() ?: ""
                Log.d("phone : ", "${phone}")
            }
        }

        // 데이터 입력 버튼 클릭 => 리턴값 있음
        binding.btnInsert.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivityInput::class.java)
            //startActivity(intent)
            activityResultLauncher.launch(intent)
        }

        // 데이터 출력 버튼 클릭 => 리턴값 없음
        binding.btnOutput.setOnClickListener {
            val intent = Intent(this, MainActivityOut::class.java)
            intent.putExtra("name", name)
            intent.putExtra("age", age)
            intent.putExtra("phone", phone)
            startActivity(intent)
        }
    }
}