package com.example.retrofitex1

import com.example.otpex.Model
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Apiinterface
{
    @FormUrlEncoded
    @POST("email.php")
    fun emailsend
    (
       @Field("first_name") first_name:String,
       @Field("email") email:String,

    ): Call<Void>

    @FormUrlEncoded
    @POST("fetchotp.php")
    fun verifyotp
    (
        @Field("email") otp:String,

    ): Call<Model>



}