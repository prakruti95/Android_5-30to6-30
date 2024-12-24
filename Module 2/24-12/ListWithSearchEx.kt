package com.example.listex1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListWithSearchEx : AppCompatActivity(){
    lateinit var listView: ListView
    lateinit var searchView: SearchView
    lateinit var list:MutableList<String>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_with_search_ex)

        listView = findViewById(R.id.list)
        searchView = findViewById(R.id.search)
        list = ArrayList()

        list.add("android")
        list.add("java")
        list.add("php")
        list.add("ios")
        list.add("kotlin")
        list.add("android2")
        list.add("java2")
        list.add("php2")
        list.add("ios2")
        list.add("kotlin2")

        var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,list)
        listView.adapter=adapter

       searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener
       {
           override fun onQueryTextSubmit(query: String?): Boolean
           {
                if(list.contains(query))
                {
                    adapter.filter.filter(query)
                }

               return false
           }

           override fun onQueryTextChange(newText: String?): Boolean
           {


                   adapter.filter.filter(newText)



               return false
           }
       })


    }



}