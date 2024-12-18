package com.example.example2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SpalshScreenActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashwithanim)

        Handler().postDelayed(Runnable {

            var i = Intent(applicationContext,MainActivity::class.java)
            startActivity(i)

        },2000)


    }
}