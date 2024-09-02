package com.example.study10retrofit.phone

import com.example.study10retrofit.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PhoneClient {
    val retrofit: PhoneInterface = Retrofit.Builder()
        .baseUrl("${BuildConfig.BASE_URL}") // .baseUrl("http://내 IP 주소:8899")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PhoneInterface::class.java)
}