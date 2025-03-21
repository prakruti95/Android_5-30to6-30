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
import com.example.appproject.Admin.Model.PaymentModel
import com.example.appproject.ApiConfig.ApiClient
import com.example.appproject.ApiConfig.Apiinterface
import com.example.appproject.Model.WishlistModel
import com.example.appproject.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PaymentAdapter(var context: Context?, var mutableList: MutableList<PaymentModel>) : RecyclerView.Adapter<PaymentAdapter.PaymentViewHolder>() {

    //lateinit var sharedPreferences: SharedPreferences

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.payment_layout, parent, false)
        return PaymentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mutableList.size
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, @SuppressLint("RecyclerView") position: Int)
    {
       // sharedPreferences = context!!.getSharedPreferences("Appproject", Context.MODE_PRIVATE)
       // val mob = sharedPreferences.getString("n1", "")

        holder.textView1.text = mutableList.get(position).pprice
        holder.textView2.text = mutableList.get(position).mobile



    }



    class PaymentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: MaterialTextView
        val textView2: MaterialTextView


        init {
            textView1 = itemView.findViewById(R.id.tvName)
            textView2 = itemView.findViewById(R.id.tvPrice)
        }
    }
}