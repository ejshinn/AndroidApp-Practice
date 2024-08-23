package com.example.study07

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.study07.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var listFragment:ListFragment

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

        // 프래그먼트(p338) => 프래그먼트매니저 메서드로 호출
        setFragment()
        binding.btnSend.setOnClickListener {
            listFragment.setValue("전달할 값")
        }
    }

    fun setFragment() {
        listFragment = ListFragment()
        var bundle = Bundle()
        bundle.putString("key1", "List Fragment")
        bundle.putInt("key2", 20240823)
        listFragment.arguments = bundle

        val transaction = supportFragmentManager.beginTransaction()
        // transaction.add(R.id.frameLayout, listFragment)
        // transaction.commit()

        transaction.run {
            add(R.id.frameLayout, listFragment)
            commit()
        }
    }

    fun goDetail() {
        val detailFragment = DetailFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, detailFragment)
        transaction.addToBackStack("detail")
        transaction.commit()
    }

    fun goBack() {
        // onBackPressed() deprecated
        onBackPressedDispatcher.onBackPressed()
    }
}