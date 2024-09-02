package com.example.study10retrofit.phone

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PhoneInterface {

    // 전체보기
    // Call :  Retrofit에서 요청과 응답을 나타내는 클래스
    // List<Phone> : 응답이 Phone 객체들의 목록임을 의미
    @GET("list")
    fun findAll(): Call<List<Phone>>

    // 추가
    // @Body로 전달된 객체는 Retrofit에 의해 JSON 형식으로 요청 본문에 포함됩
    // @Body phone: Phone : Phone 객체가 요청 본문에 포함된다는 것을 의미
    @POST("insert")
    fun save(@Body phone: Phone): Call<Phone>
    
    // 수정
    // @Path("id") id: @Path를 이용하여 URL에서 id 값을 받아옴
    // Call<Phone> : 응답으로 Phone 객체가 반환
    @PUT("update/{id}")
    fun update(@Path("id") id: Long, @Body phone: Phone): Call<Phone>
    
    // 삭제
    @DELETE("delete/{id}")
    fun deleteById(@Path("id") id: Long): Call<Void> // void : 리턴값 없음
}