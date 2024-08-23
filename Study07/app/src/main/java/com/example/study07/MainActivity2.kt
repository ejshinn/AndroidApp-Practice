package com.example.study07

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.study07.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    val binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // setContentView(R.layout.activity_main2)

//        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listener = ClickHandler()
        binding.btnSong.setOnClickListener(listener)
        binding.btnArtist.setOnClickListener(listener)
        binding.btnAlbum.setOnClickListener(listener)

        with(binding) {
            val listener = ClickHandler()
            btnSong.setOnClickListener(listener)
            btnArtist.setOnClickListener(listener)
            btnAlbum.setOnClickListener(listener)
        }

/*
        // 음악별 버튼
        binding.btnSong.setOnClickListener {
            val songFragment = SongFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer, songFragment)
            transaction.commit()
        }

        // 가수별 버튼
        binding.btnArtist.setOnClickListener {
            val artistFragment = ArtistFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer, artistFragment)
            transaction.commit()
        }

        // 앨범별 버튼
        binding.btnAlbum.setOnClickListener {
            val albumFragment = AlbumFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer, albumFragment)
            transaction.commit()
        }
 */
    }

    inner class ClickHandler(): View.OnClickListener {
        var fr: Fragment? = null

        override fun onClick(v: View?) {
            when(v!!.id) {
                binding.btnSong.id -> fr = SongFragment()
                binding.btnArtist.id -> fr = ArtistFragment()
                binding.btnAlbum.id -> fr = AlbumFragment()
            }
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fr!!).addToBackStack(null).commit()
        }
    }
}