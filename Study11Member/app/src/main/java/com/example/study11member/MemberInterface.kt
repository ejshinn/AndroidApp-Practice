package com.example.study11member

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface MemberInterface {
    // 전체보기
    @GET("list")
    fun findAll(): Call<List<Member>>

    // 추가
    @POST("insert")
    fun save(@Body member: Member):Call<Member>

    // 수정
    @PUT("update/{id}")
    fun update(@Path("id") id:Long, @Body member:Member): Call<Member>

    // 삭제
    @DELETE("delete/{id}")
    fun deleteById(@Path("id") id:Long): Call<Void>
}