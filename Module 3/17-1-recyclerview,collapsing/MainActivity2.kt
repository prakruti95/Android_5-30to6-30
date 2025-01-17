package com.example.demo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity()
{
    lateinit var recyclerView: RecyclerView
    lateinit var list: MutableList<Model>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        recyclerView = findViewById(R.id.recycler)
        list = ArrayList()

        //layoutmanager
//        var manager:RecyclerView.LayoutManager = LinearLayoutManager(this)
//        recyclerView.layoutManager=manager

        var manager:RecyclerView.LayoutManager = GridLayoutManager(this,2)
        recyclerView.layoutManager=manager



        list.add(Model("A","1111"))
        list.add(Model("B","2222"))
        list.add(Model("C","3333"))
        list.add(Model("D","4444"))

        var adapter = MyAdapter(applicationContext,list)
        recyclerView.adapter=adapter

    }
}