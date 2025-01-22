package com.example.listex1

import android.os.Bundle
import android.widget.GridView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity()
{
    lateinit var listView: GridView
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


//        listView.setOnItemClickListener { parent, view, position, id ->
//
//            if (position == 0)
//            {
//                //startActivity()
//            }
//            if (position == 1) {
//
//            }
//            if (position == 2) {
//
//            }
//            if (position == 3)
//            {
//
//            }
//
//
//
//        }
//

        var adapter = MyAdapter(applicationContext,list)
        listView.adapter=adapter
    }
}