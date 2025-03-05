package com.example.appproject.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appproject.ApiConfig.ApiClient
import com.example.appproject.ApiConfig.Apiinterface
import com.example.appproject.Model.SignupModel
import com.example.appproject.R
import com.example.appproject.databinding.ActivityLoginBinding
import com.example.appproject.databinding.ActivitySplashScreenBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityLoginBinding
    lateinit var apiinterface: Apiinterface
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        sharedPreferences = getSharedPreferences("Appproject", Context.MODE_PRIVATE)

        if(sharedPreferences.getBoolean("Appproject",false) && !sharedPreferences.getString("n1","")!!.isEmpty())
        {
            var i = Intent(applicationContext,DashboardActivity::class.java)
            startActivity(i)
            finish()
        }
        if (Build.VERSION.SDK_INT >= 21)
        {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.black)
        }

        apiinterface = ApiClient().getconnect().create(Apiinterface::class.java)

        binding.txtregister.setOnClickListener {

            startActivity(Intent(applicationContext,SignupActivity::class.java))
        }

        binding.btnLogIn.setOnClickListener {

            var phone = binding.edtPhone.text.toString()
            var pass = binding.edtPassword.text.toString()

            var call: Call<SignupModel> = apiinterface.signin(phone,pass)
            call.enqueue(object :Callback<SignupModel>
            {
                override fun onResponse(call: Call<SignupModel>, response: Response<SignupModel>) {

                    Toast.makeText(applicationContext, "Login Success", Toast.LENGTH_SHORT).show()
                    var xyz:SharedPreferences.Editor = sharedPreferences.edit()


                    var i = Intent(applicationContext,DashboardActivity::class.java)
                    xyz.putBoolean("Appproject",true)
                    xyz.putString("n1",phone)
                    xyz.commit()
                    startActivity(i)
                    //startActivity(Intent(applicationContext,DashboardActivity::class.java))
                }

                override fun onFailure(call: Call<SignupModel>, t: Throwable) {

                    Toast.makeText(applicationContext, "Login Fail", Toast.LENGTH_SHORT).show()

                }
            })

        }


    }
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}