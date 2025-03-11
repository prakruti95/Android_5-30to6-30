package com.example.appproject

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.appproject.Activity.CartAcivity
import com.example.appproject.Activity.WishlistActivity
import com.example.appproject.ApiConfig.ApiClient
import com.example.appproject.ApiConfig.Apiinterface
import com.example.appproject.Model.CartModel
import com.example.appproject.Model.WishlistModel
import com.example.appproject.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CartAdapter(var context: Context?, var mutableList: MutableList<CartModel>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    lateinit var apiInterface: Apiinterface
    lateinit var sharedPreferences: SharedPreferences



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.cart_adapter_layout, parent, false
        )
        return CartViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mutableList.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, @SuppressLint("RecyclerView") position: Int) {

        sharedPreferences = context!!.getSharedPreferences("Appproject", Context.MODE_PRIVATE)
        apiInterface = ApiClient().getconnect()!!.create(Apiinterface::class.java)
        val myId = mutableList[position].id
        val giftName = mutableList[position].gift_name
        val giftPrice = mutableList[position].gift_price
        val giftDesc = mutableList[position].gift_description
        val giftImage = mutableList[position].image
//
        holder.textView1.text = giftName
        holder.textView2.text = giftPrice
        Picasso.get().load(giftImage).into(holder.imageView)

        Log.d("MYDATA", mutableList.get(position).gift_name)

        holder.removeFromCartBtn.setOnClickListener {
            val call = apiInterface.deletecartdata(myId)
            call.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    mutableList.removeAt(position)
                    //itemClickListener!!.onItemClick(holder.adapterPosition, it)
                    Toast.makeText(context, "Removed from Cart", Toast.LENGTH_SHORT).show()
                    var i = Intent(context, CartAcivity::class.java)
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context!!.startActivity(i)
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
                }
            })
        }


    }


    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView
        val textView1: MaterialTextView
        val textView2: MaterialTextView
        val addToCartBtn: MaterialButton
        val removeFromCartBtn: MaterialButton

        init {
            imageView = itemView.findViewById(R.id.imageView)
            textView1 = itemView.findViewById(R.id.tvName)
            textView2 = itemView.findViewById(R.id.tvPrice)
            addToCartBtn = itemView.findViewById(R.id.makePayment)
            removeFromCartBtn = itemView.findViewById(R.id.removeFromCartBtn)
        }
    }
}