package com.example.listex1

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list)
        list = ArrayList()

        //set data
        list.add(Model(R.drawable.a,"Laptop1","1000"))
        list.add(Model(R.drawable.b,"Laptop2","2000"))
        list.add(Model(R.drawable.c,"Laptop3","3000"))
        list.add(Model(R.drawable.a,"Laptop1","1000"))
        list.add(Model(R.drawable.b,"Laptop2","2000"))
        list.add(Model(R.drawable.c,"Laptop3","3000"))
        list.add(Model(R.drawable.a,"Laptop1","1000"))
        list.add(Model(R.drawable.b,"Laptop2","2000"))
        list.add(Model(R.drawable.c,"Laptop3","3000"))
        list.add(Model(R.drawable.a,"Laptop1","1000"))
        list.add(Model(R.drawable.b,"Laptop2","2000"))
        list.add(Model(R.drawable.c,"Laptop3","3000"))
        list.add(Model(R.drawable.a,"Laptop1","1000"))
        list.add(Model(R.drawable.b,"Laptop2","2000"))
        list.add(Model(R.drawable.c,"Laptop3","3000"))

        var adapter = MyAdapter(applicationContext,list)
        listView.adapter=adapter
    }
}