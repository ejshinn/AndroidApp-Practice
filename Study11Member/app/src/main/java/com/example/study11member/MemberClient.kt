package com.example.study11member

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MemberClient {
    val retrofit: MemberInterface = Retrofit.Builder()
        .baseUrl("${BuildConfig.BASE_URL}") // .baseUrl("http://내 IP 주소:8811/member/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MemberInterface::class.java)
}