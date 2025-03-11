package com.example.appproject.Activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appproject.ApiConfig.ApiClient
import com.example.appproject.ApiConfig.Apiinterface
import com.example.appproject.CartAdapter
import com.example.appproject.Model.CartModel
import com.example.appproject.Model.WishlistModel
import com.example.appproject.WishlistAdapter
import com.example.appproject.databinding.ActivityCartBinding
import com.example.appproject.databinding.ActivityWishlistBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartAcivity : AppCompatActivity()
{
    private lateinit var binding: ActivityCartBinding
    private lateinit var mutableList: MutableList<CartModel>
    lateinit var apiInterface: Apiinterface
    lateinit var sharedPreferences: SharedPreferences
    lateinit var mAdapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        val view = binding.root
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Setting up ActionBar
        binding.mToolbar.title = "My Cart"
        setSupportActionBar(binding.mToolbar)
        binding.mToolbar.setNavigationOnClickListener {

            startActivity(Intent(applicationContext,DashboardActivity::class.java))


        }
        setContentView(view)
        // Setting up activity window


        mutableList = ArrayList()
        mAdapter = CartAdapter(applicationContext, mutableList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        //sharedprefrence
        sharedPreferences = getSharedPreferences("Appproject", MODE_PRIVATE)
        val mob = sharedPreferences.getString("n1", "")


        apiInterface = ApiClient().getconnect()!!.create(Apiinterface::class.java)
        val call = apiInterface.viewcartdata(mob)
        call.enqueue(object : Callback<List<CartModel>> {
            override fun onResponse(
                call: Call<List<CartModel>>,
                response: Response<List<CartModel>>
            ) {

                //Log.d("Mydata123",response.body().toString())


                mutableList = response.body() as MutableList<CartModel>
                Toast.makeText(applicationContext, ""+mutableList.size, Toast.LENGTH_SHORT).show()

                mAdapter = CartAdapter(applicationContext, mutableList)
                binding.recyclerView.adapter = mAdapter
                //binding.progressIndicator.visibility = View.GONE

            }

            override fun onFailure(call: Call<List<CartModel>>, t: Throwable) {
                Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
            }
        })

    }


}
