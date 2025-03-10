package com.example.appproject.ApiConfig

import com.example.appproject.Model.CategoryModel
import com.example.appproject.Model.DashboardModel
import com.example.appproject.Model.SignupModel
import com.example.appproject.Model.WishlistModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
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


    @FormUrlEncoded
    @POST("user_login.php")
    fun signin
      (
        @Field("user_phone") user_phone:String,
        @Field("user_password") user_password:String
      ): Call<SignupModel>

    @GET("dashboard_view.php")
    fun dashboardviewdata() : Call<List<DashboardModel>>

    @FormUrlEncoded
    @POST("category_view.php")
    fun categoryviewdata
                (
        @Field("data") data: Int?,
    ): Call<List<CategoryModel>>

    @FormUrlEncoded
    @POST("add_data_to_wishlist.php")
    fun addwishlist
                (
        @Field("gift_name") gift_name:String?,
        @Field("gift_description") gift_description:String?,
        @Field("gift_price") gift_price:String?,
        @Field("image") image:String?,
        @Field("mobile") mobile:String?,
        ): Call<Void>

    @FormUrlEncoded
    @POST("viewwishlist.php")
    fun viewwishlistdata
                (
        @Field("mobile") data: String?,
    ): Call<List<WishlistModel>>
}