package com.example.firebasecrudex

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity()
{
    lateinit var f1: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        f1 = findViewById(R.id.f1)
        f1.setOnClickListener {

            startActivity(Intent(applicationContext,AdduserActivity::class.java))
        }
    }
}