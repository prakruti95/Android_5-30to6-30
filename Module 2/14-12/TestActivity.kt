package com.example.firstapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class TestActivity : AppCompatActivity()
{
    //declare -object create
    lateinit var image1: ImageView
    lateinit var text1: TextView


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        //initialize
        //connect kotlin and XML

        image1 = findViewById(R.id.img)
        text1 = findViewById(R.id.txt)

        image1.setOnClickListener {

            Toast.makeText(applicationContext,"Clicked",Toast.LENGTH_LONG).show()

            //Intent ->

//            Intent : Switching from one acitivity to another activity
//                1)Explicit Intent : Switching from one acitivity to another activity in same app
//                2)Implicit Intent : Switching from one acitivity to another activity between diffrent app

            //Explicit Intent

            var i = Intent(applicationContext,MainActivity2::class.java)
            startActivity(i)




        }

        text1.setOnClickListener {

            Toast.makeText(applicationContext, "Text Clicked", Toast.LENGTH_SHORT).show()

            //Implicit Intent
            var url = "https://www.geeksforgeeks.org/android-tutorial/"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)
        }



    }
}