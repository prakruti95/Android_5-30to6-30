package com.example.otpex

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.retrofitex1.ApiClient
import com.example.retrofitex1.Apiinterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button
    lateinit var apiinterface: Apiinterface

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1 = findViewById(R.id.edtfname)
        edt2 = findViewById(R.id.edtemail)
        btn1 = findViewById(R.id.btn1)

        apiinterface = ApiClient().getapiclient().create(Apiinterface::class.java)

        btn1.setOnClickListener {


            var name = edt1.text.toString()
            var email = edt2.text.toString()

           var call: Call<Void> =  apiinterface.emailsend(name,email)

            call.enqueue(object:Callback<Void>
            {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {

                    Toast.makeText(applicationContext, "Email Send", Toast.LENGTH_SHORT).show()

                    var i = Intent(applicationContext,SecondActivity::class.java)
                    i.putExtra("myemail",email)
                    startActivity(i)
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext, "Email Sending Fail", Toast.LENGTH_SHORT).show()

                }
            })



        }

    }
}