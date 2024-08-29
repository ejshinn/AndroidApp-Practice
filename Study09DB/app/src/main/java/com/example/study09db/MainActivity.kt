package com.example.study09db

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.study09db.databinding.ActivityMainBinding

// 생성한 DB 파일 위치 찾기
// 왼쪽 상단의 View -> ToolWindows -> Device Explorer 클릭
// data 폴더 -> data 폴더 -> 현재 패키지 폴더 -> database 폴더

class MainActivity : AppCompatActivity() {
    var sqLiteDatabase:SQLiteDatabase? = null
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 데이터베이스 생성
        binding.btnDB.setOnClickListener {
            binding.textView.text = ""

            sqLiteDatabase = openOrCreateDatabase(binding.edtDB.text.toString(),
                MODE_PRIVATE, null)

            output("데이터베이스생성 :: ${binding.edtDB.text}")
        }

        // 테이블 생성
        binding.btnTable.setOnClickListener {
            binding.textView.text = ""

            val tableName = binding.edtTable.text.toString()

            if(sqLiteDatabase == null) {
                output("데이터베이스를 생성하세요")
                return@setOnClickListener
            }

            val sql = "create table if not exists $tableName(" +
                    "id integer primary key autoincrement," +
                    "name text," +
                    "age integer," +
                    "phone text)"

            sqLiteDatabase!!.execSQL(sql)
            output("테이블 생성 : $tableName")
        }

        // 데이터 입력
        binding.btnInsert.setOnClickListener {
            binding.textView.text = ""

            val tableName = binding.edtTable.text.toString()

            if(sqLiteDatabase == null) {
                output("데이터베이스를 생성하세요")
                return@setOnClickListener
            }

            if(tableName == null) {
                output("테이블을 생성하세요")
                return@setOnClickListener
            }

            output("데이터 입력 버튼 호출")

            val sql = "insert into ${tableName}(name, age, phone)" +
                    "values('안드로이드', 20, '010-1111-2222')"

            sqLiteDatabase!!.execSQL(sql)
            output("데이터 추가")
        }

        // 데이터 조회
        binding.btnSelect.setOnClickListener {
            binding.textView.text = ""

            val tableName = binding.edtTable.text.toString()

            if(sqLiteDatabase == null) {
                output("데이터베이스를 생성하세요")
                return@setOnClickListener
            }

            if(tableName == null) {
                output("테이블을 생성하세요")
                return@setOnClickListener
            }

            output("데이터 조회 버튼 호출")
            val sql = "select * from $tableName"
            val cursor = sqLiteDatabase!!.rawQuery(sql, null)

            while(cursor.moveToNext()) {
                val id = cursor.getInt(0)
                val name = cursor.getString(1)
                val age = cursor.getInt(2)
                val phone = cursor.getString(3)

                output("$id // $name // $age // $phone")
            }
        }
    }

    private fun output(str: String) {
        binding.textView.append(str + "\n")
    }
}