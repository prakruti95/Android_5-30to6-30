package com.example.listex1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity()
{
    lateinit var alist:MutableList<Model>
    lateinit var blist:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var i = intent
        var pos = i.getIntExtra("pos",404)
        Toast.makeText(applicationContext, ""+pos, Toast.LENGTH_SHORT).show()

        alist = ArrayList()
        blist = ArrayList()

        alist.add()



        if(pos==0)
        {
            var adapter = MyAdapter(applicationContext,alist)
        }
        if(pos==1)
        {
            var adapter = MyAdapter(applicationContext,blist)
        }
        if(pos==2)
        {
            var adapter = MyAdapter(applicationContext,flist)
        }
        if(pos==3)
        {
            var adapter = MyAdapter(applicationContext,vlist)
        }
    }
}