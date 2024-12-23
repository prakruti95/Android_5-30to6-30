package com.example.listex1

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list:MutableList<String>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list)
        list = ArrayList()

        list.add("Lion")
        list.add("Tiger")
//        list.add("Lion")
//        list.add("Tiger")
//        list.add("Lion")
//        list.add("Tiger")
//        list.add("Lion")
//        list.add("Tiger")
//        list.add("Lion")
//        list.add("Tiger")
//        list.add("Lion")
//        list.add("Tiger")
//        list.add("Lion")
//        list.add("Tiger")
//        list.add("Lion")
//        list.add("Tiger")
//        list.add("Lion")
//        list.add("Tiger")
//        list.add("Lion")
//        list.add("Tiger")
//        list.add("Lion")
//        list.add("Tiger")
//        list.add("Lion")
//        list.add("Tiger")
//        list.add("Lion")
//        list.add("Tiger")
//        list.add("Lion")
//        list.add("Tiger")
//        list.add("Lion")
//        list.add("Tiger")
//        list.add("Lion")
//        list.add("Tiger")
//        list.add("Lion")
//        list.add("Tiger")
//        list.add("Lion")
//        list.add("Tiger")

        //Adapter
        registerForContextMenu(listView)

        var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,list)
        listView.adapter=adapter

//        listView.setOnItemClickListener { parent, view, position, id ->
//
//            if(position==0)
//            {
//                Toast.makeText(applicationContext, "1", Toast.LENGTH_SHORT).show()
//            }
//            if(position==1)
//            {
//                Toast.makeText(applicationContext, "2", Toast.LENGTH_SHORT).show()
//
//            }
//
//
//        }
//

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        menuInflater.inflate(R.menu.context,menu)

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {

        var acm :AdapterContextMenuInfo = item.menuInfo as AdapterContextMenuInfo
        var pos = acm.position

        //Toast.makeText(applicationContext, ""+pos, Toast.LENGTH_SHORT).show()

        when(item.itemId)
        {
            R.id.voice_speak->
            {

                Toast.makeText(applicationContext, "Speak", Toast.LENGTH_SHORT).show()
            }
            R.id.voice_sound->
            {
                Toast.makeText(applicationContext, "Sound", Toast.LENGTH_SHORT).show()

            }
        }
        return super.onContextItemSelected(item)
    }

}