package com.example.study04

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.study04.databinding.ActivityDialog2Binding
import com.example.study04.databinding.ActivityDialogBinding
import com.example.study04.databinding.ActivityMain2Binding
import com.example.study04.databinding.ProgressbarBinding
import java.util.Date

// p286
class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main2)

        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 기본 다이얼로그 클릭 이벤트
        binding.btnBasic.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("기본 Alert Dialog")
                setMessage("안드로이드에서 제공하는 기본 Alert Dialog 사용하기")
                setPositiveButton("확인", null)
                show()
            }
        }

        // Custom 다이얼로그 클릭
        binding.btnCustom.setOnClickListener {
            val dialogBinding = ActivityDialogBinding.inflate(layoutInflater)
            var rdoText = ""

            dialogBinding.rdoGroup.setOnCheckedChangeListener{radioGroup, i ->
                if(i == dialogBinding.rdoM.id) {
                    rdoText = dialogBinding.rdoM.text.toString()
                }
                else {
                    rdoText = dialogBinding.rdoF.text.toString()
                }
            }

            AlertDialog.Builder(this).run {
                setTitle("커스텀 다이얼로그")
                setView(dialogBinding.root) // 커스텀으로 만든 화면
                setPositiveButton("확인", object:DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        Toast.makeText(this@MainActivity2, rdoText, Toast.LENGTH_SHORT).show()
                    }
                })
                show()
            }
        }

        // Custom 다이얼로그2 클릭
        binding.btnCustom2.setOnClickListener {
            val dialogBinding = ActivityDialog2Binding.inflate(layoutInflater)

            AlertDialog.Builder(this).run {
                setTitle("커스텀 다이얼로그")
                setView(dialogBinding.root) // 커스텀으로 만든 화면

                setNeutralButton("보류", null)
                setNegativeButton("취소", null)
                setPositiveButton("확인", object:DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        // mainActivity2에 있는 이름에 다이얼로그에서 적은 이름 넣기
                        binding.txName.text = "이름 : ${dialogBinding.edtName.text}"
                        binding.txAge.text = "나이 : ${dialogBinding.edtAge.text}"
                    }
                })
                show()
            }
        }
        
        // 데이트 픽커 다이얼로그 => Calender
        binding.btnDatePicker.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR) // 년
            val month = calendar.get(Calendar.MONTH) // 월(0~11)
            val day = calendar.get(Calendar.DAY_OF_MONTH) // 일

            // (DatePicker!, Int, Int, Int) -> Unit
            var listener = DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                binding.txName.text = "현재 날짜 : ${i}년 ${i2+1}월 ${i3}일"
            }

            var picker = DatePickerDialog(this, listener, year, month, day)
            picker.show()
        }
        
        // 타임픽커 다이얼로그
        binding.btnTimePicker.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR)
            val minute = calendar.get(Calendar.MINUTE)
            val second = calendar.get(Calendar.SECOND)
            val listener = TimePickerDialog.OnTimeSetListener { timePicker, i, i2 ->
                binding.txName.text = "시각 : ${i}시 ${i2}분"
            }

            var picker = TimePickerDialog(this, listener, hour, minute, false)
            picker.show()
        }

        // 프로그래스바 => AlertDialog에 띄우기
        binding.btnProgress.setOnClickListener{
            var builder = AlertDialog.Builder(this)
            builder.setTitle("프로그래스바")
            builder.setIcon(R.mipmap.ic_launcher)

            val pbinding = ProgressbarBinding.inflate(layoutInflater)
            builder.setView(pbinding.root)

            builder.show()
        }
    }
}