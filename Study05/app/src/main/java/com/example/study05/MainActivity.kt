package com.example.study05

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.study05.databinding.ActivityMainBinding
import com.example.study05.databinding.DialogInputBinding

// p286
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

        binding.button.setOnClickListener {
            val items = arrayOf<String>("사과", "복숭아", "딸기")

            AlertDialog.Builder(this).run {
                setTitle("items test")
                setIcon(android.R.drawable.ic_dialog_info)

                setMultiChoiceItems(items, booleanArrayOf(true, false, true, false), object: DialogInterface.OnMultiChoiceClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int, p2: Boolean) {
                        Log.d("MultiChoiceItems", "${items[p1]}가 ${if(p2) "선택되었습니다." else "선택 해제되었습니다."}")
                    }
                })

                setPositiveButton("닫기", null)
                show()
            } // run
        } // button

        // Custom dialog
        binding.button2.setOnClickListener {
            val dialogBinding = DialogInputBinding.inflate(layoutInflater)

            // 라디오 그룹 선택
            var txt = ""
            dialogBinding.rdoGroup.setOnCheckedChangeListener { radioGroup, i ->
                if(i == dialogBinding.rdoM.id) txt = "남자"
                else txt = "여자"
                dialogBinding.edtTxt.setText(txt)
            }

            AlertDialog.Builder(this).run {
                setTitle("custom")
                setView(dialogBinding.root)
                setNegativeButton("취소", null)
                setPositiveButton("확인", object:DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        Log.d("custom", "${txt}")
                    }
                })
                show()
            }
        }
    }
}