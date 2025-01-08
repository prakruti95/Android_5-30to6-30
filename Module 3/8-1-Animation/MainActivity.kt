package com.example.animationex

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.Menu
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.animationex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    lateinit var binding:ActivityMainBinding
    lateinit var animationDrawable: AnimationDrawable
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        toolbar = findViewById(R.id.tool)
        setSupportActionBar(toolbar)

        animationDrawable= binding.img1.background as AnimationDrawable


        binding.btn1.setOnClickListener {

            //Tween animation


//            var animation:Animation = AnimationUtils.loadAnimation(applicationContext,R.anim.blink)
//           // animation.start()
//            binding.btn1.startAnimation(animation)


            //Frame Animation
            if(animationDrawable.isRunning())
            {
                animationDrawable.stop()
            }
            else
            {
                animationDrawable.start()
            }



        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
       menuInflater.inflate(R.menu.test1,menu)
        return super.onCreateOptionsMenu(menu)
    }
}