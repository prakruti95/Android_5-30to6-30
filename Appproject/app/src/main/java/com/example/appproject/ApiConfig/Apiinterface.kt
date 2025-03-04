package com.example.appproject.ApiConfig

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Apiinterface
{
    @FormUrlEncoded
    @POST("user_signup.php")
    fun signup
      (
        @Field("user_first_name") user_first_name:String,
        @Field("user_last_name") user_last_name:String,
        @Field("user_phone") user_phone:String,
        @Field("user_gender") user_gender:String,
        @Field("user_email") user_email:String,
        @Field("user_password") user_password:String,
        @Field("type") type:String
        ): Call<Void>

}