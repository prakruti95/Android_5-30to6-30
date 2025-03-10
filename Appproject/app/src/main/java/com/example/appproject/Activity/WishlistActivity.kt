package com.example.appproject.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appproject.ApiConfig.ApiClient
import com.example.appproject.ApiConfig.Apiinterface
import com.example.appproject.Model.WishlistModel
import com.example.appproject.R
import com.example.appproject.WishlistAdapter
import com.example.appproject.databinding.ActivityCategoryViewBinding
import com.example.appproject.databinding.ActivityWishlistBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WishlistActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityWishlistBinding
    private lateinit var mutableList: MutableList<WishlistModel>
    lateinit var apiInterface: Apiinterface
    lateinit var sharedPreferences: SharedPreferences
    lateinit var mAdapter: WishlistAdapter


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityWishlistBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        apiInterface = ApiClient().getconnect().create(Apiinterface::class.java)
        mutableList = ArrayList()
        sharedPreferences = getSharedPreferences("Appproject", Context.MODE_PRIVATE)
        var mob = sharedPreferences.getString("n1", "")
        var manager:RecyclerView.LayoutManager = GridLayoutManager(this,2)
        binding.recycler.layoutManager=manager

        val call = apiInterface.viewwishlistdata(mob!!)
        call.enqueue(object : Callback<List<WishlistModel>> {
            override fun onResponse(
                call: Call<List<WishlistModel>>,
                response: Response<List<WishlistModel>>
            ) {

                Log.d("Mydata123",response.body().toString())


                mutableList = response.body() as MutableList<WishlistModel>
                //Toast.makeText(applicationContext, "Topsdata:"+mutableList.size, Toast.LENGTH_SHORT).show()
               mAdapter = WishlistAdapter(applicationContext, mutableList)
                //binding.progressIndicator.visibility = View.GONE
               binding.recycler.adapter = mAdapter
            }

            override fun onFailure(call: Call<List<WishlistModel>>, t: Throwable) {
                Toast.makeText(this@WishlistActivity, "Failed", Toast.LENGTH_SHORT).show()
            }
        })


        //apiInterface = ApiClient().getconnect()!!.create(Apiinterface::class.java)
//        WindowCompat.setDecorFitsSystemWindows(window, false)
//        binding.mToolbar.title = "My Wishlist"
//        setSupportActionBar(binding.mToolbar)
//        sharedPreferences = getSharedPreferences("Appproject", Context.MODE_PRIVATE)
//        var mob = sharedPreferences.getString("n1", "")
//        binding.mToolbar.setNavigationOnClickListener {
//
//            startActivity(Intent(applicationContext,DashboardActivity::class.java))
//
//
//        }
        //setContentView(view)
//        mutableList = ArrayList()
//        binding.recycler.layoutManager = GridLayoutManager(this,2)
//
//        val call = apiInterface.viewwishlistdata("9275003605")
//        call.enqueue(object : Callback<List<WishlistModel>> {
//            override fun onResponse(
//                call: Call<List<WishlistModel>>,
//                response: Response<List<WishlistModel>>
//            ) {
//
//                //Log.d("Mydata123",response.body().toString())
//
//
//                mutableList = response.body() as MutableList<WishlistModel>
//                //Toast.makeText(applicationContext, "Topsdata:"+mutableList.size, Toast.LENGTH_SHORT).show()
//                mAdapter = WishlistAdapter(applicationContext, mutableList)
//                //binding.progressIndicator.visibility = View.GONE
//                binding.recycler.adapter = mAdapter
//            }
//
//            override fun onFailure(call: Call<List<WishlistModel>>, t: Throwable) {
//                Toast.makeText(this@WishlistActivity, "Failed", Toast.LENGTH_SHORT).show()
//            }
//        })
    }
}