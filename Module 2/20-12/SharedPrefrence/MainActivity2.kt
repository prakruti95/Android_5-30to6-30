package com.example.example2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity()
{
    lateinit var toolbar: Toolbar
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        toolbar = findViewById(R.id.tool)
        setSupportActionBar(toolbar)

        sharedPreferences = getSharedPreferences("MYSESSION", Context.MODE_PRIVATE)
        toolbar.setSubtitle("WELCOME "+sharedPreferences.getString("n1","NameError"))

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        //inflate-show
        menuInflater.inflate(R.menu.option_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.i1->
            {
                //finishAffinity()
                sharedPreferences.edit().clear().commit()
                var i = Intent(applicationContext,MainActivity::class.java)
                startActivity(i)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {

        finishAffinity()
        super.onBackPressed()

    }



}