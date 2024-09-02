package com.example.study10retrofit.phone

import android.content.DialogInterface
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.study10retrofit.R
import com.example.study10retrofit.databinding.ActivityMainBinding
import com.example.study10retrofit.databinding.CustomPhoneBinding
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var phoneAdapter: PhoneAdapter? = null

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

        val phoneList = mutableListOf<Phone>()
        phoneAdapter = PhoneAdapter(phoneList)
        binding.recyclerView.adapter = phoneAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // 전체보기
        binding.btnList.setOnClickListener {
            PhoneClient.retrofit.findAll().enqueue(object :retrofit2.Callback<List<Phone>>{
                override fun onResponse(call: Call<List<Phone>>, response: Response<List<Phone>>) {
                    phoneAdapter!!.phoneList = response.body() as MutableList<Phone> // List<Phone>을 MutableList<Phone>으로 캐스팅
                    phoneAdapter?.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<List<Phone>>, t: Throwable) {
                }
            })
        }

        // 추가(+) 버튼 클릭
        binding.floatingBtn.setOnClickListener {
            val dialogPhone = CustomPhoneBinding.inflate(layoutInflater)
            AlertDialog.Builder(this).run {
                setTitle("추가")
                setMessage("여기서 추가 내용을 입력하세요")
                setView(dialogPhone.root)

                setPositiveButton("추가", object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {

                        val p = Phone(0, dialogPhone.edtName.text.toString(), dialogPhone.edtPhone.text.toString())

                        PhoneClient.retrofit.save(p).enqueue(object :retrofit2.Callback<Phone>{
                            override fun onResponse(call: Call<Phone>, response: Response<Phone>) {
                                // Log.d("response", "${response.body()}")

                                // phoneAdapter.addItem(response.body())
                                response.body()?.let { it1 -> phoneAdapter!!.addItem(it1) } // reponse.body()가 null이 아니면 어댑터에 있는 addItem에 값을 전달함
                            }

                            override fun onFailure(call: Call<Phone>, t: Throwable) {

                            }
                        })
                    }
                })

                setNegativeButton("취소", null)
                show()
            }
        }
    }
}